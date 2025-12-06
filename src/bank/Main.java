package bank;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        Account acc1 = new SavingsAccount("A100", "Ali", 1000);
        Account acc2 = new CheckingAccount("B200", "Veli", 500, 200);

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        
        acc1.deposit(200);   
        acc2.withdraw(600);  

        System.out.println("Hesap 1 Bakiye: " + acc1.getBalance());
        System.out.println("Hesap 2 Bakiye: " + acc2.getBalance());

        System.out.println("Sistem test edildi, hata yok.");
    }
}
