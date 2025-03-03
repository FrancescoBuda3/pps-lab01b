package e1;

class BankAccountDecorator implements BankAccount {

    protected final BankAccount base;

    public BankAccountDecorator(BankAccount base) {
        this.base = base;
    }

    public int getBalance() {
        return this.base.getBalance();
    }

    public void deposit(int amount) { this.base.deposit(amount);}

    public void withdraw(int amount) {
        this.base.withdraw(amount);
    }
}
