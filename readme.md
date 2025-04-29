The entities and relationships appear to be structured like this:
1. main.java.com.example.Bank Class

   Contains accounts stored in a LinkedHashMap<Long, main.java.com.example.Account>.
   Implements main.java.com.example.BankInterface.
   Provides methods for opening different types of accounts, authenticating users, checking balances, crediting, and debiting amounts.

2. main.java.com.example.Account Class

   Represents the core entity with details such as accountHolder, accountNumber, pin, and balance.
   Implements main.java.com.example.AccountInterface.

3. main.java.com.example.Account Holder

   Contains details like idNumber.
   Can hold one or more accounts.

4. main.java.com.example.Person

   Contains firstName, lastName, idNumber, and represents the human entity.
   Used for individual account creation.

5. main.java.com.example.Company

   Represents a business with companyName and taxId, used in creating commercial accounts.

6. main.java.com.example.ConsumerAccount and main.java.com.example.CommercialAccount

   Inherit from main.java.com.example.Account, each representing different account types (personal and commercial).
   main.java.com.example.CommercialAccount can have authorizedUsers (Persons).

7. main.java.com.example.Transaction Class

   Used to handle operations like credit, debit, and balance checking.

8. Interfaces

   main.java.com.example.BankInterface: Defines operations for account handling.
   main.java.com.example.TransactionInterface: Defines operations for transactions.
   main.java.com.example.AccountInterface: Defines operations related to account activities.

### Class Diagram

<img src="/docs/image.png" width="1600" height="300" alt="Class Diagram"/>

### Project Setup in Java

    Define Interfaces
    The three interfaces (main.java.com.example.BankInterface, main.java.com.example.TransactionInterface, main.java.com.example.AccountInterface) will define the contract for the core operations.

    Define Entity Classes
    Create Java classes for main.java.com.example.Bank, main.java.com.example.Account, main.java.com.example.ConsumerAccount, main.java.com.example.CommercialAccount, main.java.com.example.Person, main.java.com.example.Company, main.java.com.example.Transaction, and main.java.com.example.AccountHolder.

    Use Composition and Inheritance
    Set up relationships like main.java.com.example.Account having an main.java.com.example.AccountHolder and main.java.com.example.Transaction referring to a main.java.com.example.Bank and main.java.com.example.Account.

    Handle Transactions
    Implement methods for operations like credit, debit, and getBalance using the respective interface methods.