package com.shivam.java_6_interfaces;

// ==========================
// ABSTRACTION & INTERFACES IN JAVA
// With WHAT, WHY, WHEN, HOW, RULES, PROS, CONS, Example + Output
// ==========================

// 1. WHAT
/*
- Abstraction: Hiding implementation details, showing only essential features.
- Interface: A contract specifying what a class must do, without defining how.
*/

// 2. WHY
/*
- Reduce complexity and improve design clarity.
- Allow multiple implementations of the same behavior.
- Support loosely coupled code.
*/

// 3. WHEN
/*
- Use abstraction when you want to define general behavior but leave details for subclasses.
- Use interfaces when multiple classes need to implement the same behavior in their own way.
*/

// 4. HOW
/*
- Abstract class: Use 'abstract' keyword. Can have abstract and non-abstract methods.
- Interface: Use 'interface' keyword. Only method declarations (Java 8+ allows default/static methods).
- Implement interface using 'implements', extend abstract class using 'extends'.
*/

// 5. RULES / NOTES
/*
- Abstract classes cannot be instantiated directly.
- Interfaces can have multiple implementations.
- A class can implement multiple interfaces (Java allows multiple inheritance via interfaces).
- Abstract class can have fields and constructors; interfaces cannot have instance fields.
- Methods in interface are public abstract by default.
- By default, variables in an interface are public, static and final.
- It supports loose coupling (classes depend on behavior, not implementation).
- An interface in Java defines a set of behaviours that a class can implement, usually representing a CAN-DO relationship, but not always in every scenario.

*/

// 6. PROS
/*
- Abstraction: Clean API, hides implementation, reusable code.
- Interface: Multiple inheritance, enforce consistent behavior, decouple code.
*/

// 7. CONS
/*
- Too many abstract layers may increase complexity.
- Interfaces cannot store state (only constants or static/default fields).
*/

// ==========================
// EXAMPLE: ABSTRACTION AND INTERFACE
// ==========================
abstract class Vehicle {  // Abstract class
    abstract void start(); // Abstract method
    void fuel() {          // Non-abstract method
        System.out.println("Filling fuel...");
    }
}

// Interface
interface Horn {
    void honk(); // Must be implemented
}

class Car extends Vehicle implements Horn { // Concrete class
    @Override
    void start() {
        System.out.println("Car started.");
    }

    @Override
    public void honk() {
        System.out.println("Car horn: Beep Beep!");
    }
}

public class AbstractionInterfaceDemo {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.fuel();  // inherited non-abstract method
        myCar.start(); // abstract method implemented in subclass

        Horn hornCar = (Horn) myCar;
        hornCar.honk(); // interface method
    }
}

/*
EXPECTED OUTPUT:
Filling fuel...
Car started.
Car horn: Beep Beep!
*/

/*
==========================
SUMMARY
==========================
- Abstraction hides implementation, exposes essential behavior.
- Abstract classes can have abstract + concrete methods.
- Interfaces define a contract; classes implement it.
- Use abstract classes for shared code, interfaces for multiple inheritance.
- Pros: Clean design, reusability, decoupling.
- Cons: Too many layers = complexity; interfaces cannot have instance fields.
*/

