import java.util.List;

public class CommercialAccount extends Account {
    private List<Person> authorizedUsers;

    public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
        super(company, accountNumber, pin, startingDeposit);
    }

    protected void addAuthorizedUser(Person person) {
        this.authorizedUsers.add(person);
    }

    public boolean isAuthorizedUser(Person person) {
        return this.authorizedUsers.contains(person);
    }
}