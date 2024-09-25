// Main.java
public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        // Create a person and a company
        Person johnDoe = new Person("John", "Doe", 1234);
        Company xyzCorp = new Company("XYZ Corporation", 5678);

        // Open a consumer account for John Doe
        Long johnAccountNumber = bank.openConsumerAccount(johnDoe, 1234, 1000.00);
        System.out.println("John's Account Number: " + johnAccountNumber);

        // Open a commercial account for XYZ Corp
        Long xyzAccountNumber = bank.openCommercialAccount(xyzCorp, 5678, 5000.00);
        System.out.println("XYZ Corporation's Account Number: " + xyzAccountNumber);

        // Authenticate and perform transactions
        Transaction johnTransaction = new Transaction(bank, johnAccountNumber, 1234);
        johnTransaction.credit(500.00);
        System.out.println("John's New Balance: " + johnTransaction.getBalance());

        johnTransaction.debit(200.00);
        System.out.println("John's New Balance after Debit: " + johnTransaction.getBalance());

        // Commercial account transactions
        Transaction xyzTransaction = new Transaction(bank, xyzAccountNumber, 5678);
        xyzTransaction.debit(1000.00);
        System.out.println("XYZ Corporation's New Balance: " + xyzTransaction.getBalance());
    }
}

/* Simple output:
John's Account Number: 1727281726921
XYZ Corporation's Account Number: 1727281726927
John's New Balance: 1500.0
John's New Balance after Debit: 1300.0
XYZ Corporation's New Balance: 4000.0

----

John's Account Number: 1727281744363
XYZ Corporation's Account Number: 1727281744368
John's New Balance: 1500.0
John's New Balance after Debit: 1300.0
XYZ Corporation's New Balance: 4000.0
*/