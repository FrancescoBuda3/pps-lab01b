package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends CoreBankAccountTest {


    @Override
    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @Override
    @Test
    public void testCanWithdraw() {
        this.account.deposit(BASE_DEPOSIT);
        this.account.withdraw(TEST_WITHDRAW);
        assertEquals(BASE_DEPOSIT-TEST_WITHDRAW-SilverBankAccount.FEE, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(BASE_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(BASE_DEPOSIT+1));
    }

}
