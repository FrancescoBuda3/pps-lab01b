package e1;

public interface BankAccountFactory {
    BankAccount createSilverBankAccount(int fee);
    BankAccount createGoldBankAccount(int overdraft);
    BankAccount createBronzeBankAccount();
}
