package bank;

/**
 * SavingsAccount sınıfı.
 * <p>
 * Faiz kazancı sağlayan tasarruf hesabını temsil eder.
 */
public class SavingsAccount extends Account {

    private double interestRate;

    /**
     * SavingsAccount constructor.
     *
     * @param accountNumber hesap numarası
     * @param ownerName     hesap sahibi
     * @param balance       başlangıç bakiyesi
     */
    public SavingsAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
        this.interestRate = 0.02;
    }

    /**
     * Hesaptan para çekme işlemi.
     * Yetersiz bakiye durumunda hata fırlatır.
     *
     * @param amount çekilecek miktar
     */
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

    /**
     * Hesaba aylık faiz uygular.
     */
    public void applyMonthlyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }
}