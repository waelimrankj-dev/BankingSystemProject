package bank;

public interface Transferable {
    void transfer(Account from, Account to, double amount);
}
