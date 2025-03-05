package e1;

public class FeeBankAccount extends BankAccountDecorator {

    public final int fee;
    public final int threshold;

    public FeeBankAccount(BankAccount base, int fee, int threshold) {
        super(base);
        this.fee = fee;
        this.threshold = threshold;
    }

    @Override
    public void withdraw(int amount) {
        if (amount < this.threshold) {
            this.base.withdraw(amount);
        } else {
            this.base.withdraw(amount + fee);
        }
    }
}
