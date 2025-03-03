package e1;

public class FeeBankAccount extends BankAccountDecorator {

    public final int fee;

    public FeeBankAccount(BankAccount base, int fee) {
        super(base);
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + fee);
    }
}
