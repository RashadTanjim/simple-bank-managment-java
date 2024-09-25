The entities and relationships appear to be structured like this:
1. Bank Class

   Contains accounts stored in a LinkedHashMap<Long, Account>.
   Implements BankInterface.
   Provides methods for opening different types of accounts, authenticating users, checking balances, crediting, and debiting amounts.

2. Account Class

   Represents the core entity with details such as accountHolder, accountNumber, pin, and balance.
   Implements AccountInterface.

3. Account Holder

   Contains details like idNumber.
   Can hold one or more accounts.

4. Person

   Contains firstName, lastName, idNumber, and represents the human entity.
   Used for individual account creation.

5. Company

   Represents a business with companyName and taxId, used in creating commercial accounts.

6. ConsumerAccount and CommercialAccount

   Inherit from Account, each representing different account types (personal and commercial).
   CommercialAccount can have authorizedUsers (Persons).

7. Transaction Class

   Used to handle operations like credit, debit, and balance checking.

8. Interfaces

   BankInterface: Defines operations for account handling.
   TransactionInterface: Defines operations for transactions.
   AccountInterface: Defines operations related to account activities.

### Class Diagram

<img src="/docs/image.png" width="1600" height="300" alt="Class Diagram"/>

### Project Setup in Java

    Define Interfaces
    The three interfaces (BankInterface, TransactionInterface, AccountInterface) will define the contract for the core operations.

    Define Entity Classes
    Create Java classes for Bank, Account, ConsumerAccount, CommercialAccount, Person, Company, Transaction, and AccountHolder.

    Use Composition and Inheritance
    Set up relationships like Account having an AccountHolder and Transaction referring to a Bank and Account.

    Handle Transactions
    Implement methods for operations like credit, debit, and getBalance using the respective interface methods.