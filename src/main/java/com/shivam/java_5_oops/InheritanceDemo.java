package com.shivam.java_5_oops;

// ==========================
// INHERITANCE IN JAVA
// With WHAT, WHY, WHEN, HOW, TYPES, RULES, PROS, CONS, Example + Output
// ==========================

// 1. WHAT
/*
- Inheritance: Mechanism where one class (child/subclass) acquires properties and behavior (fields & methods) of another class (parent/superclass).
- Enables code reuse and hierarchical relationships.
*/

// 2. WHY
/*
- Reuse existing code without rewriting.
- Model real-world "is-a" relationships.
- Organize classes in a hierarchical structure.
*/

// 3. WHEN
/*
- Use inheritance when multiple classes share common behavior.
- Example: Employees and Managers, Devices and Smartphones.
*/

// 4. HOW
/*
- Use 'extends' keyword to inherit from a superclass.
- Subclass inherits all non-private fields and methods.
- Subclass can override superclass methods for specific behavior.
- Use 'super()' to call parent constructor.
*/

// 5. TYPES OF INHERITANCE IN JAVA
/*
Java supports several types of inheritance using classes and interfaces:
1. Single Inheritance: One subclass inherits from one superclass.
2. Multilevel Inheritance: Class B inherits from A, Class C inherits from B.
3. Hierarchical Inheritance: Multiple subclasses inherit from a single superclass.
4. Multiple Inheritance via Interfaces: A class implements multiple interfaces to achieve multiple inheritance.
*/

//// Examples of types:
class Vehicle {  // Superclass
    void start() { System.out.println("Vehicle started"); }
}

// Single Inheritance
class Car extends Vehicle {
    void drive() { System.out.println("Car is driving"); }
}

// Multilevel Inheritance
class SportsCar extends Car {
    void turbo() { System.out.println("SportsCar turbo mode activated"); }
}

// Hierarchical Inheritance
class Bike extends Vehicle {
    void ride() { System.out.println("Bike is riding"); }
}

// Multiple Inheritance via Interface
interface GPS {
    void navigate();
}
interface MusicSystem {
    void playMusic();
}
class SmartCar extends Vehicle implements GPS, MusicSystem {
    public void navigate() { System.out.println("SmartCar navigating route"); }
    public void playMusic() { System.out.println("SmartCar playing music"); }
}

// 6. RULES / NOTES
/*
- Java supports single inheritance only for classes (to avoid ambiguity).
- Multiple inheritance can be achieved via interfaces.
- Private members are not inherited.
- Subclass constructor can call parent constructor using 'super()'.
- Overriding methods must have same signature and compatible return type.
*/

// 7. PROS
/*
- Code reusability.
- Logical hierarchy representation.
- Enables polymorphism.
*/

// 8. CONS
/*
- Tight coupling between parent and child.
- Overuse may create fragile base classes.
- Only single inheritance allowed for classes.
*/

// ==========================
// MAIN EXAMPLE
// ==========================
public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Single Inheritance ===");
        Car car = new Car();
        car.start();  // inherited
        car.drive();

        System.out.println("\n=== Multilevel Inheritance ===");
        SportsCar sc = new SportsCar();
        sc.start();  // from Vehicle
        sc.drive();  // from Car
        sc.turbo();  // own method

        System.out.println("\n=== Hierarchical Inheritance ===");
        Bike bike = new Bike();
        bike.start(); // from Vehicle
        bike.ride();  // own method

        System.out.println("\n=== Multiple Inheritance via Interface ===");
        SmartCar smartCar = new SmartCar();
        smartCar.start();       // from Vehicle
        smartCar.navigate();    // from GPS
        smartCar.playMusic();   // from MusicSystem
    }
}

/*
EXPECTED OUTPUT:
=== Single Inheritance ===
Vehicle started
Car is driving

=== Multilevel Inheritance ===
Vehicle started
Car is driving
SportsCar turbo mode activated

=== Hierarchical Inheritance ===
Vehicle started
Bike is riding

=== Multiple Inheritance via Interface ===
Vehicle started
SmartCar navigating route
SmartCar playing music
*/

/*
==========================
SUMMARY
==========================
- Inheritance allows classes to acquire properties & methods from another class.
- Types:
  1. Single Inheritance: One subclass, one superclass
  2. Multilevel: Chain of inheritance
  3. Hierarchical: Multiple subclasses from same superclass
  4. Multiple via Interfaces
- Pros: Code reuse, logical hierarchy, enables polymorphism.
- Cons: Tight coupling, fragile base class, limited class inheritance (single only).
- Use inheritance for "is-a" relationships in real-world modeling.
*/

