package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    @Override
    @BeforeEach
    void init(){
        BankAccountFactory factory = new BankAccountFactoryImpl();
        this.account = factory.createBronzeBankAccount();
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(BASE_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(BASE_DEPOSIT+1));
    }

    @Test
    public void dontApplyFeeWithSmallWithdrawal(){
        this.account.deposit(BASE_DEPOSIT);
        int smallWithdrawal = 50;
        this.account.withdraw(smallWithdrawal);
        assertEquals(BASE_DEPOSIT- smallWithdrawal, this.account.getBalance());
    }

}
