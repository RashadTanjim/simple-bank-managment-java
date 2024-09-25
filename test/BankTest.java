import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {
    private Bank bank;
    private Person johnDoe;
    private Company xyzCorp;
    private Long johnAccountNumber;
    private Long xyzAccountNumber;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        johnDoe = new Person("John", "Doe", 1234);
        xyzCorp = new Company("XYZ Corp", 5678);

        // Open accounts
        johnAccountNumber = bank.openConsumerAccount(johnDoe, 1234, 1000.00);
        xyzAccountNumber = bank.openCommercialAccount(xyzCorp, 5678, 5000.00);
    }

    @Test
    public void testOpenConsumerAccount() {
        Assertions.assertNotNull(johnAccountNumber, "Account number should not be null");
    }

    @Test
    public void testOpenCommercialAccount() {
        Assertions.assertNotNull(xyzAccountNumber, "Account number should not be null");
    }

    @Test
    public void testAuthenticateUser() {
        Assertions.assertTrue(bank.authenticateUser(johnAccountNumber, 1234), "Authentication should succeed");
        Assertions.assertFalse(bank.authenticateUser(johnAccountNumber, 9999), "Authentication should fail with wrong pin");
    }

    @Test
    public void testCredit() {
        Assertions.assertTrue(bank.credit(johnAccountNumber, 500.00), "Credit should succeed");
        Assertions.assertEquals(1500.00, bank.getBalance(johnAccountNumber), 0.01, "Balance should be updated after credit");
    }

    @Test
    public void testDebit() {
        Assertions.assertTrue(bank.debit(johnAccountNumber, 300.00), "Debit should succeed");
        Assertions.assertEquals(700.00, bank.getBalance(johnAccountNumber), 0.01, "Balance should be updated after debit");
    }

    @Test
    public void testDebitWithInsufficientFunds() {
        Assertions.assertFalse(bank.debit(johnAccountNumber, 2000.00), "Debit should fail with insufficient funds");
        Assertions.assertEquals(1000.00, bank.getBalance(johnAccountNumber), 0.01, "Balance should not change");
    }

    @Test
    public void testTransactionCredit() {
        Transaction transaction = new Transaction(bank, johnAccountNumber, 1234);
        Assertions.assertTrue(transaction.credit(500.00), "Credit through transaction should succeed");
        Assertions.assertEquals(1500.00, transaction.getBalance(), 0.01, "Balance should be updated after credit");
    }

    @Test
    public void testTransactionDebit() {
        Transaction transaction = new Transaction(bank, johnAccountNumber, 1234);
        Assertions.assertTrue(transaction.debit(300.00), "Debit through transaction should succeed");
        Assertions.assertEquals(700.00, transaction.getBalance(), 0.01, "Balance should be updated after debit");
    }

    @Test
    public void testTransactionDebitInsufficientFunds() {
        Transaction transaction = new Transaction(bank, johnAccountNumber, 1234);
        Assertions.assertFalse(transaction.debit(2000.00), "Debit with insufficient funds should fail");
        Assertions.assertEquals(1000.00, transaction.getBalance(), 0.01, "Balance should remain unchanged");
    }
}
