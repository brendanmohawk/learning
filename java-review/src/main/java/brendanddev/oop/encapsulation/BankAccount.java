package brendanddev.oop.encapsulation;


/**
 * A BankAccount class that demonstrates encapsulation principles in Java.
 * 
 * Encapsulation means hiding internal data (fields) and only exposing controlled access through public methods (getters/setters and behaviors).
 * This helps protect the intergrity of the data and prevent improper usage.
 * 
 * Access modifiers control visibility and access to class members
 * 
 * - private: Only accessible within the class itself. Used for sensitive data that should not be accessible outisde the class.
 * - protected: Accessible within the class and subclasses (even if they are in different packages). Used for data that should be shared with subclasses but not with the outside world.
 * - public: Accessible from anywhere. Used for methods that need to be called from outside the class.
 * - default (no modifier): Accessible only within the same package. Used for package-private access.
 */
public class BankAccount {

    // Private fields, fully encapsulated and only accessible inside this class or through public methods
    private int accountId;
    private String accountNumber;
    private double balance;

    // Protected field, accessible in subclasses and within the same package
    protected String accountHolderName;

    // Public field, accessible from anywhere
    public String bankName = "National Bank";

    /**
     * Constructs a new BankAccount object with a default balance of 0.0
     */
    public BankAccount(int accountId, String accountNumber, String accountHolderName) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    /** 
     * Constructs a new BankAccount object with a specified initial balance
     */
    public BankAccount(int accountId, String accountNumber, String accountHolderName, double initialBalance) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        setBalance(initialBalance);
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Bank Name: " + bankName);
    }

    private void setBalance(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative.");
            this.balance = 0.0;
        }
    }

}
