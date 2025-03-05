package e1;

public class BankAccountFactoryImpl implements BankAccountFactory {
    @Override
    public BankAccount createSilverBankAccount(int fee) {
        return new FeeBankAccount(new CanWithdrawBankAccount(new CoreBankAccount(), 0), fee, 0);
    }

    @Override
    public BankAccount createGoldBankAccount(int overdraft) {
        return new CanWithdrawBankAccount(new CoreBankAccount(), overdraft);
    }

    @Override
    public BankAccount createBronzeBankAccount(int fee, int threshold) {
        return new FeeBankAccount(new CanWithdrawBankAccount(new CoreBankAccount(), 0),  fee, threshold);
    }
}
