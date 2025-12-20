package bank;

/**
 * Abstract sınıf: Account
 * <p>
 * Banka sistemindeki tüm hesap türleri için temel sınıftır.
 * Encapsulation, inheritance ve polymorphism prensiplerini uygular.
 */
public abstract class Account {

    private String accountNumber;
    private String ownerName;
    private double balance;

    /**
     * Account constructor.
     *
     * @param accountNumber Hesap numarası
     * @param ownerName     Hesap sahibinin adı
     * @param balance       Başlangıç bakiyesi
     */
    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    /**
     * Hesap numarasını döndürür.
     *
     * @return account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Hesap sahibinin adını döndürür.
     *
     * @return owner name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Güncel bakiyeyi döndürür.
     *
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Hesaba para yatırma işlemi.
     *
     * @param amount yatırılacak miktar
     * @throws IllegalArgumentException negatif veya sıfır miktar girilirse
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }

    /**
     * Hesaptan para çekme işlemi.
     * <p>
     * Bu metod hesap türüne göre farklı davranır (polymorphism).
     *
     * @param amount çekilecek miktar
     */
    public abstract void withdraw(double amount);

    /**
     * Bakiyeyi güvenli şekilde günceller.
     *
     * @param amount yeni bakiye
     */
    protected void setBalance(double amount) {
        this.balance = amount;
    }
}
