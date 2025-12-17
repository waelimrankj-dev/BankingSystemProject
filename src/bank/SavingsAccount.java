package bank;

public class SavingsAccount extends Account {

    private double interestRate; 

    public SavingsAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
        this.interestRate = 0.02; 
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

    
    public void applyMonthlyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }
}
