package bank;

public class CheckingAccount extends Account {

    private double overdraftLimit;


    public CheckingAccount(String accountNumber, String ownerName, double balance, double overdraftLimit) {
        super(accountNumber, ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

   
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > getBalance() + overdraftLimit) {
            throw new IllegalArgumentException("Overdraft limiti aşıldı");
        }
        setBalance(getBalance() - amount);
    }
}
