package com.mmm.corebanking.daos.jpa;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MonytaryAmountJpaConverter implements AttributeConverter<MonetaryAmount, String> {

    @Override
    public String convertToDatabaseColumn(MonetaryAmount attribute) {

        if (attribute == null) {
            return null;
        }
        return Money.from(attribute).toString();
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(String dbData){
        if (dbData == null) {
            return null;
        }
        return Money.parse(dbData);
    }

}
