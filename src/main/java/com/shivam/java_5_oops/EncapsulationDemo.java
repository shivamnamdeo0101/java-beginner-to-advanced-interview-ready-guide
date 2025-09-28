package com.shivam.java_5_oops;

// ==========================
// ENCAPSULATION IN JAVA
// With WHAT, WHY, WHEN, HOW, RULES, PROS, CONS, Example + Output
// ==========================

// 1. WHAT
/*
- Encapsulation: Wrapping data (fields) and methods into a single unit (class).
- Restrict direct access to some fields and provide controlled access via getters/setters.
*/

// 2. WHY
/*
- Protect sensitive data from unwanted access/modification.
- Maintain integrity of object state.
- Makes code more maintainable and modular.
*/

// 3. WHEN
/*
- Always use encapsulation for class fields, especially in real-world applications like banking, inventory, etc.
- Use when you need controlled access to class variables.
*/

// 4. HOW
/*
- Declare class fields as private.
- Provide public getter and setter methods to access and modify fields.
- Optionally, add validation inside setter methods.
*/

// 5. RULES / NOTES
/*
- Private fields cannot be accessed directly from outside the class.
- Getters usually named getFieldName(), setters setFieldName().
- Can add logic in setters (e.g., validation).
- Constructors can also be used to initialize private fields.
*/

// 6. PROS
/*
- Data hiding: protects internal state.
- Flexibility: validation and logic can be added in getters/setters.
- Maintains class invariants and integrity.
*/

// 7. CONS
/*
- More boilerplate code (getters and setters).
- Slight overhead due to method calls instead of direct access.
*/

// ==========================
// EXAMPLE: ENCAPSULATION
// ==========================
class BankAccount {
    // Private fields
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance");
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account = new BankAccount("ACC12345", 1000);

        // Access via getters/setters
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Initial Balance: " + account.getBalance());

        account.deposit(500);       // Deposited: 500
        account.withdraw(200);      // Withdrawn: 200
        account.withdraw(2000);     // Invalid withdraw amount or insufficient balance

        System.out.println("Final Balance: " + account.getBalance());
    }
}

/*
EXPECTED OUTPUT:
Account Number: ACC12345
Initial Balance: 1000.0
Deposited: 500.0
Withdrawn: 200.0
Invalid withdraw amount or insufficient balance
Final Balance: 1300.0
*/

/*
==========================
SUMMARY
==========================
- Encapsulation = private fields + public getters/setters.
- Protects object state, allows validation, maintains integrity.
- Pros: Security, flexibility, maintainability.
- Cons: More boilerplate, minor performance overhead.
- Always prefer encapsulation for class design in Java.
*/

