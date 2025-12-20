package bank;

/**
 * CheckingAccount sınıfı.
 * <p>
 * Overdraft (eksi bakiye) özelliği olan vadesiz hesap türüdür.
 */
public class CheckingAccount extends Account {

    private double overdraftLimit;

    /**
     * CheckingAccount constructor.
     *
     * @param accountNumber  hesap numarası
     * @param ownerName      hesap sahibi
     * @param balance        başlangıç bakiyesi
     * @param overdraftLimit izin verilen eksi bakiye limiti
     */
    public CheckingAccount(String accountNumber, String ownerName, double balance, double overdraftLimit) {
        super(accountNumber, ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Overdraft limitini dikkate alarak para çekme işlemi yapar.
     *
     * @param amount çekilecek miktar
     */
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
