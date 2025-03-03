package e1;

public class BankAccountFactoryImpl implements BankAccountFactory {
    @Override
    public BankAccount createSilverBankAccount(int fee) {
        return new FeeBankAccount(new CanWithdrawBankAccount(new CoreBankAccount()), fee);
    }
}
