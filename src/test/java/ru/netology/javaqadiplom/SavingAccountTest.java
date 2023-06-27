
package ru.netology.javaqadiplom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5
        );
        account.add(3_000);
        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldNotAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5
        );
        account.add(9_000);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldNotAddIfAmountNegative() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5
        );
        account.add(-9_000);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldNotAddIfAmountZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5
        );
        account.add(0);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldPayIfBalanceAboveMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5
        );
        account.pay(500);
        Assertions.assertEquals(1500, account.getBalance());
    }

       @Test
    public void shouldNotPayIfBalanceUnderMinBalance() {
        SavingAccount account = new SavingAccount(1000, 1_000, 10_000, 5
        );
        account.pay(500);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldNotPayIfAmountNegative() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5
        );
        account.pay(-1500);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldNotPayIfAmountZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5
        );
        account.pay(0);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldNotPayIfBalanceNegative() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5
        );
        account.pay(-15000);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldCalculateRate() {
        SavingAccount account = new SavingAccount(200, 100, 10_000, 15
        );
        Assertions.assertEquals(30, account.yearChange());
    }

    @Test
    public void shouldThrowExceptionIfRateNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(200, 100, 10_000, -15));
    }

    @Test
    public void shouldThrowExceptionIfMinBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(200, -100, 10_000, 15));
    }

    @Test
    public void shouldThrowExceptionIfBalanceLowerThanMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(200, 400, 10_000, 15));
    }

    @Test
    public void shouldThrowExceptionIfBalanceMoreThanMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(11000, -100, 10_000, 15));
    }

    @Test
    public void shouldThrowExceptionIfMinBalanceMoreThanMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(0, 1000, 700, 15));
    }
}
