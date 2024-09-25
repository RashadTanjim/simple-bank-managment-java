public class Transaction implements TransactionInterface {

    private final Long accountNumber;
    private final Bank bank;

    public Transaction(Bank bank, Long accountNumber, int attemptedPin) {
        if (bank.authenticateUser(accountNumber, attemptedPin)) {
            this.bank = bank;
            this.accountNumber = accountNumber;
        } else {
            throw new SecurityException("Invalid pin.");
        }
    }

    @Override
    public double getBalance() {
        return bank.getBalance(accountNumber);
    }

    @Override
    public void credit(double amount) {
        bank.credit(accountNumber, amount);
    }

    @Override
    public boolean debit(double amount) {
        return bank.debit(accountNumber, amount);
    }
}