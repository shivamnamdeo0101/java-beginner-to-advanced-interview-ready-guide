package com.shivam.java_1_meta;

// ==========================================================
// Java Example: Static vs Instance Methods & Variables
// ==========================================================

class Car {
    // ----------------------------
    // Instance variable
    // Each object has its own copy
    // ----------------------------
    String name;

    // ----------------------------
    // Static variable
    // Belongs to class, shared by all objects
    // ----------------------------
    static int wheels = 4;

    // ----------------------------
    // Constructor
    // Called when creating an object
    // Sets object-specific (instance) variable
    // ----------------------------
    Car(String name) {
        this.name = name;
    }

    // ======================================================
    // Instance Method
    // ------------------------------------------------------
    // - Belongs to object
    // - Can access instance + static variables
    // - Requires object to call
    // ======================================================
    void displayInfo() {
        System.out.println("=== Instance Method ===");
        System.out.println("Car name: " + name);      // Access instance variable
        System.out.println("Wheels: " + wheels);      // Access static variable
    }

    // ======================================================
    // Static Method
    // ------------------------------------------------------
    // - Belongs to class
    // - Can access only static variables
    // - Can be called without creating an object
    // ======================================================
    static void printWheels() {
        System.out.println("=== Static Method ===");
        System.out.println("All cars have " + wheels + " wheels");
        // System.out.println(name); // ❌ Cannot access instance variable directly
    }
}

class Demo {
    int x = 10;        // instance variable
    static int y = 20; // static variable

    // Instance method
    void instanceMethod() {
        System.out.println("Inside Instance Method:");
        System.out.println("x = " + x + ", y = " + y);
        staticMethod(); // ✅ Instance method can call static method
    }

    // Static method
    static void staticMethod() {
        System.out.println("Inside Static Method:");
        System.out.println("y = " + y);
        // System.out.println(x);      // ❌ Cannot access instance variable
        // instanceMethod();           // ❌ Cannot call instance method directly
    }
}

public class InstanseAndStaticMethod {
    public static void main(String[] args) {

        // ----------------------------
        // 1️⃣ Instance Method Example
        // ----------------------------
        // Need to create object to call
        Car myCar = new Car("Honda");
        myCar.displayInfo();

        // ----------------------------
        // 2️⃣ Static Method Example
        // ----------------------------
        // Can call directly using class name
        Car.printWheels();

        // ----------------------------
        // 3️⃣ Mixing Static and Instance
        // ----------------------------
        Demo obj = new Demo();
        obj.instanceMethod();  // Instance method can call static method
        Demo.staticMethod();   // Static method called without object

        // ----------------------------
        // 4️⃣ Key Takeaways
        // ----------------------------
        // Instance Method:
        // - Belongs to object
        // - Can access instance + static variables
        // - Requires object to call

        // Static Method:
        // - Belongs to class
        // - Can access only static variables
        // - Can be called using ClassName.methodName()
        // - Often used for utility methods
    }
}

