package bank;

import java.time.LocalDateTime;

public class Transaction {

    private LocalDateTime date;
    private String type;  
    private double amount;
    private String accountNumber;

    public Transaction(String type, double amount, String accountNumber) {
        this.date = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return date + " | " + type + " | " + amount + " | Hesap: " + accountNumber;
    }
}
