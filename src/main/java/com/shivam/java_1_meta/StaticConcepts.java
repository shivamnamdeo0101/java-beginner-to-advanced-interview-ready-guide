package com.shivam.java_1_meta;

// ==========================================================
// 🔹 STATIC in Java
// ==========================================================
// `static` keyword means → belongs to the CLASS, not to objects.
// It is loaded once in memory (class-level), shared across all objects.
//
// Types:
// 1. static variables   → Shared by all objects
// 2. static methods     → Can be called without object
// 3. static block       → Runs once when class loads (used for initialization)
// 4. static nested class → Class inside another class with `static` keyword
//
// ✅ Why use?
// - Saves memory (shared variable instead of copy per object).
// - Utility methods that don’t depend on object state.
// - Class-level initialization logic.
// ==========================================================

class Counter {
    // -------------------------
    // 1. static variable
    // -------------------------
    static int count = 0; // shared across all objects
    int objId;            // instance variable (separate per object)

    // Constructor increments both counters
    Counter() {
        count++;     // affects all objects
        objId = count; // assign id
    }

    // -------------------------
    // 2. static method
    // -------------------------
    static void showCount() {
        // System.out.println(objId); // ❌ ERROR: can't use non-static (object) variables
        System.out.println("Static Count = " + count);
    }

    // instance method can access both static + non-static
    void showDetails() {
        System.out.println("Object ID = " + objId + ", Shared Count = " + count);
    }
}

// -------------------------
// 3. static block
// -------------------------
// Runs only once when class is first loaded into memory.
class StaticBlockDemo {
    static {
        System.out.println("Static Block: Class Loaded → Initialization done!");
    }

    StaticBlockDemo() {
        System.out.println("Constructor: Object Created");
    }
}

// -------------------------
// 4. static nested class
// -------------------------
// A static class inside another class
class Outer {
    int outerVar = 100;
    static int staticOuterVar = 200;

    // static nested class
    static class Inner {
        void display() {
            // System.out.println(outerVar); // ❌ ERROR: can't access non-static outer member
            System.out.println("Accessing outer static variable = " + staticOuterVar);
        }
    }
}

// ==========================================================
// Main Class
// ==========================================================
public class StaticConcepts {
    public static void main(String[] args) {

        System.out.println("=== Static Variable & Static Method ===");
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();

        c1.showDetails();
        c2.showDetails();
        c3.showDetails();
        c4.showDetails();

        // static method → call via class name (preferred)
        Counter.showCount();

        System.out.println("\n=== Static Block Demo ===");
        StaticBlockDemo obj1 = new StaticBlockDemo();
        StaticBlockDemo obj2 = new StaticBlockDemo(); // static block runs only once

        System.out.println("\n=== Static Nested Class Demo ===");
        // Create object of static nested class without outer object
        Outer.Inner innerObj = new Outer.Inner();
        innerObj.display();
    }
}

