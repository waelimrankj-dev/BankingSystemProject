package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;
    private Account acc1;
    private Account acc2;

    @BeforeEach
    void setup() {
        bank = new Bank();
        acc1 = new SavingsAccount("A100", "Ali", 1000);
        acc2 = new CheckingAccount("B200", "Veli", 500, 200);

        bank.addAccount(acc1);
        bank.addAccount(acc2);
    }

    @Test
    void testDeposit() {
        bank.deposit("A100", 500);
        assertEquals(1500, acc1.getBalance());
    }

    @Test
    void testWithdrawSavingsAccount() {
        bank.withdraw("A100", 300);
        assertEquals(700, acc1.getBalance());
    }

    @Test
    void testWithdrawCheckingAccountWithOverdraft() {
        bank.withdraw("B200", 600);
        assertEquals(-100, acc2.getBalance());
    }

    @Test
    void testTransfer() {
        bank.transfer("A100", "B200", 400);
        assertEquals(600, acc1.getBalance());
        assertEquals(900, acc2.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            bank.deposit("A100", -100);
        });
    }

    @Test
    void testWithdrawInsufficientBalanceSavings() {
        assertThrows(IllegalArgumentException.class, () -> {
            bank.withdraw("A100", 2000);
        });
    }
}

