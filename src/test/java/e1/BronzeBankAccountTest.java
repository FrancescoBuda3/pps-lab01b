package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    public static final int FEE = 1;
    public static final int THRESHOLD = 100;

    @Override
    @BeforeEach
    void init(){
        BankAccountFactory factory = new BankAccountFactoryImpl();
        this.account = factory.createBronzeBankAccount(FEE, THRESHOLD);
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

    @Test
    public void applyFeeWithLargeWithdrawal(){
        this.account.deposit(BASE_DEPOSIT);
        int largeWithdrawal = 150;
        this.account.withdraw(largeWithdrawal);
        assertEquals(BASE_DEPOSIT-largeWithdrawal- FEE, this.account.getBalance());
    }

}
