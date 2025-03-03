package e1;

public class SilverBankAccount extends BankAccountDecorator {

    public static final int FEE = 1;

    public SilverBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + FEE);
    }
}
