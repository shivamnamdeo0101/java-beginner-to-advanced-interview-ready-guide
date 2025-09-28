package com.shivam.java_6_interfaces;

// =======================================
// Interface Before Java 8 (Full Abstraction)
// =======================================
interface VehicleBeforeJava8 {
    void start();   // abstract by default
    void stop();    // abstract by default
    // No method body allowed
}

// Example class implementing the interface
class Bike implements VehicleBeforeJava8 {
    @Override
    public void start() {
        System.out.println("Bike is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping...");
    }
}

// =======================================
// Problem Before Java 8
// =======================================
/*
Suppose you have an interface used by many classes:
interface Vehicle {
    void start();
}

Later, you want to add a new method:
interface Vehicle {
    void start();
    void stop();  // new method
}

❌ All existing classes implementing Vehicle break,
because they must now implement stop().
*/

// =======================================
// Solution in Java 8: Default Methods
// =======================================
interface VehicleAfterJava8 {
    void start();   // abstract method

    // Default method (has body) → solves backward compatibility
    default void stop() {
        System.out.println("Stopping vehicle");
    }

    // Static method (has body)
    static void info() {
        System.out.println("This is a modern vehicle interface.");
    }
}

// Class implementing the interface (no need to implement stop)
class ElectricScooter implements VehicleAfterJava8 {
    @Override
    public void start() {
        System.out.println("Electric Scooter is starting silently...");
    }
}

// =======================================
// Main class to test both scenarios
// =======================================
public class InterfaceDemo {
    public static void main(String[] args) {

        System.out.println("---- Before Java 8 ----");
        VehicleBeforeJava8 bike = new Bike();
        bike.start();
        bike.stop();

        System.out.println("\n---- After Java 8 (Default Method Example) ----");
        VehicleAfterJava8 scooter = new ElectricScooter();
        scooter.start();       // abstract method
        scooter.stop();        // default method
        VehicleAfterJava8.info(); // static method from interface
    }
}

/* =========================================
Output:

---- Before Java 8 ----
Bike is starting...
Bike is stopping...

---- After Java 8 (Default Method Example) ----
Electric Scooter is starting silently...
Stopping vehicle
This is a modern vehicle interface.

Explanation:
1. Before Java 8: interfaces = 100% abstract → full abstraction
   - Adding new methods breaks existing classes
2. Java 8 solution: default methods
   - Provide implementation in interface
   - Existing classes do not break
   - Interface now has some concrete code → partial abstraction
========================================= */
