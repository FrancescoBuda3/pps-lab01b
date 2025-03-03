package e1;

public class CanWithdrawBankAccount extends BankAccountDecorator {

    public CanWithdrawBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount);
    }
}
