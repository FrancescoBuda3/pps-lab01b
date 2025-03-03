package e1;

public class CanWithdrawBankAccount extends BankAccountDecorator {
    private final int overdraft;

    public CanWithdrawBankAccount(BankAccount base, int overdraft) {
        super(base);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + overdraft < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount);
    }
}
