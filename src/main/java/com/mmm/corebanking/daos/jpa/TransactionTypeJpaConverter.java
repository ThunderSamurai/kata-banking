package com.mmm.corebanking.daos.jpa;

import com.mmm.corebanking.entites.TransactionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TransactionTypeJpaConverter implements AttributeConverter<TransactionType, String> {

    @Override
    public String convertToDatabaseColumn(TransactionType attribute) {

        if (attribute == null) {
            return null;
        }
        return attribute.equals(TransactionType.WITHDRAWL)?String.valueOf(1):String.valueOf(0);
    }

    @Override
    public TransactionType convertToEntityAttribute(String dbData){
        if (dbData == null) {
            return null;
        }
        return TransactionType.WITHDRAWL.ordinal()==Long.valueOf(dbData)?TransactionType.WITHDRAWL:TransactionType.DEPOSIT;
    }

}
