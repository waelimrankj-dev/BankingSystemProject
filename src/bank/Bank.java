package bank;

import java.util.ArrayList;
import java.util.List;
/**
 * Bank sınıfı.
 * <p>
 * Banka içindeki tüm hesapları ve işlemleri yöneten ana sınıftır.
 */
public class Bank {

    private List<Account> accounts;
    private List<Transaction> transactions;
 /**
 * Bank constructor.
 */
    public Bank() {
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }
    /**
     * Bankaya yeni hesap ekler.
     *
     * @param account eklenecek hesap
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    /**
     * Belirtilen hesaba para yatırır.
     *
     * @param accountNumber hesap numarası
     * @param amount        yatırılacak miktar
     */
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
/**
 * Belirtilen hesaptan para çeker.
 *
 * @param accountNumber hesap numarası
 * @param amount        çekilecek miktar
 */
 void withdraw(String accountNumber, double amount) {

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

    
    target.withdraw(amount);

    transactions.add(new Transaction("WITHDRAW", amount, accountNumber));
}
 /**
  * İki hesap arasında para transferi yapar.
  *
  * @param fromAccount gönderen hesap
  * @param toAccount   alıcı hesap
  * @param amount      transfer miktarı
  */
public void transfer(String fromAccount, String toAccount, double amount) {

    if (amount <= 0) {
        throw new IllegalArgumentException("Amount must be positive");
    }

    Account sender = null;
    Account receiver = null;

    for (Account acc : accounts) {
        if (acc.getAccountNumber().equals(fromAccount)) {
            sender = acc;
        }
        if (acc.getAccountNumber().equals(toAccount)) {
            receiver = acc;
        }
    }

    if (sender == null || receiver == null) {
        throw new IllegalArgumentException("Hesap bulunamadı");
    }

    if (sender == receiver) {
        throw new IllegalArgumentException("Aynı hesaba transfer yapılamaz");
    }

    
    sender.withdraw(amount);

   
    receiver.deposit(amount);


    transactions.add(new Transaction("TRANSFER", amount, fromAccount + " -> " + toAccount));
}
/**
 * Hesaba ait tüm işlem geçmişini döndürür.
 *
 * @param accountNumber hesap numarası
 * @return işlem listesi
 */
public List<Transaction> getTransactionHistory(String accountNumber) {

    List<Transaction> history = new ArrayList<>();

    for (Transaction t : transactions) {
        if (t.getAccountNumber().contains(accountNumber)) {
            history.add(t);
        }
    }

    return history;
}
}

