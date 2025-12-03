package bank;

public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > getBalance()) {
            throw new IllegalArgumentException("Yetersiz bakiye");
        }

        setBalance(getBalance() - amount);
    }
}
