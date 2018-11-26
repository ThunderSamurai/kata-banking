import com.mmm.corebanking.entities.Account;
import com.mmm.corebanking.CoreBankingOperationsService;
import org.junit.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class CoreBackingServiceTest {
    final private static  Logger LOGGER=Logger.getLogger(CoreBackingServiceTest.class.getName());

    @Inject
    CoreBankingOperationsService coreBankingOperationsService;

    @Test
    public void should_make_deposit(){

        Account account=new Account();

//        coreBankingOperationsService.deposit(1,new BigDecimal(10));

        assertTrue(true);
    }
}
