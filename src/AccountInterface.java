public interface AccountInterface {

    Long getAccountNumber();

    double getBalance();

    boolean credit(double amount);

    boolean debit(double amount);

    boolean validatePin(int attemptedPin);
}