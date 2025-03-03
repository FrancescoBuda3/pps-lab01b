package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends CoreBankAccountTest {

    public static final int OVERDRAFT = 500;

    @Override
    @BeforeEach
    void init(){
        BankAccountFactory factory = new BankAccountFactoryImpl();
        this.account = factory.createGoldBankAccount(OVERDRAFT);
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(BASE_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(BASE_DEPOSIT+OVERDRAFT+1));
    }

}
