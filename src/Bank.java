import java.util.LinkedHashMap;

public class Bank implements BankInterface {
    private final LinkedHashMap<Long, Account> accounts = new LinkedHashMap<>();

    @Override
    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        Long accountNumber = generateAccountNumber();
        CommercialAccount account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    @Override
    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        Long accountNumber = generateAccountNumber();
        ConsumerAccount account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    @Override
    public boolean authenticateUser(Long accountNumber, int pin) {
        Account account = accounts.get(accountNumber);
        return account != null && account.validatePin(pin);
    }

    @Override
    public double getBalance(Long accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return -1;
    }

    @Override
    public boolean credit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        return account != null && account.credit(amount);
    }

    @Override
    public boolean debit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        return account != null && account.debit(amount);
    }

    private Long generateAccountNumber() {
        return System.currentTimeMillis();  // Simple account number generation
    }
}