package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;
    private List<Transaction> transactions;

    public Bank() {
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    
public void deposit(String accountNumber, double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        Account target = null;

        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                target = acc;
                break;
            }
        }

        if (target == null) {
            throw new IllegalArgumentException("Hesap bulunamadı");
        }

        target.deposit(amount);

        transactions.add(new Transaction("DEPOSIT", amount, accountNumber));
    }

}

