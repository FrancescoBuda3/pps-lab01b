package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoreBankAccountTest {

    public static final int BASE_DEPOSIT = 1000;
    public static final int TEST_WITHDRAW = 200;
    protected BankAccount account;

    @BeforeEach
    void init(){
        this.account = new CoreBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(BASE_DEPOSIT);
        assertEquals(BASE_DEPOSIT, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(BASE_DEPOSIT);
        this.account.withdraw(TEST_WITHDRAW);
        assertEquals(BASE_DEPOSIT-TEST_WITHDRAW, this.account.getBalance());
    }

}
