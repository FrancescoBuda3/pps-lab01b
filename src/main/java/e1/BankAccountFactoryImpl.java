package e1;

public class BankAccountFactoryImpl implements BankAccountFactory {
    @Override
    public BankAccount createSilverBankAccount(int fee) {
        return new FeeBankAccount(new CanWithdrawBankAccount(new CoreBankAccount(), 0), fee);
    }

    @Override
    public BankAccount createGoldBankAccount(int overdraft) {
        return new CanWithdrawBankAccount(new CoreBankAccount(), overdraft);
    }

    @Override
    public BankAccount createBronzeBankAccount() {
        return new CanWithdrawBankAccount(new CoreBankAccount(), 0);
    }
}
