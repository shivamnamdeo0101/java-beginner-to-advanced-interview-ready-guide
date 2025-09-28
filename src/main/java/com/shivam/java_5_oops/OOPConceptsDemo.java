package com.shivam.java_5_oops;
// ==========================
// OOPS Concepts in Java
// With WHAT, WHY, WHEN, HOW, RULES, PROS, CONS, Example + Output
// ==========================

// 1. CLASSES & OBJECTS
/*
WHAT: Class is a blueprint; Object is an instance of a class.
WHY: To model real-world entities in a structured way.
WHEN: Whenever you need modular, reusable code.
HOW: Use 'class' keyword, create object with 'new'.
RULES: Class name should be PascalCase; object names camelCase.
PROS: Reusability, scalability, maintainability.
CONS: Slight overhead in memory compared to primitives.
*/
class Car {
    String brand;
    int speed;

    void drive() {
        System.out.println(brand + " is driving at " + speed + " km/h");
    }
}

// 2. CONSTRUCTORS
/*
TYPES:
1. Default Constructor → No parameters.
2. Parameterized Constructor → Takes arguments.
3. Copy Constructor → Copies data from another object.

WHAT: Special methods to initialize objects.
WHY: To give objects valid initial values.
WHEN: At object creation.
HOW: Same name as class, no return type, can overload.
RULES: No return type, not static/final/abstract, auto-called with new.
PROS: Ensures initialization, can overload.
CONS: Too many overloads can be confusing.
*/
class Point {
    int x, y;

    Point() { this.x = 0; this.y = 0; } // default
    Point(int x, int y) { this.x = x; this.y = y; } // parameterized
    Point(Point p) { this.x = p.x; this.y = p.y; } // copy

    void display() { System.out.println("Point: (" + x + "," + y + ")"); }
}

// 3. OBJECT CLASS
/*
IMPORTANT METHODS:
- toString()
- equals(Object o)
- hashCode()
- clone()
- finalize()
- getClass()

WHAT: Root class of all Java classes.
WHY: Provides basic methods (toString, equals, hashCode).
WHEN: Always implicitly inherited.
HOW: Every class extends Object by default.
RULES: Override toString/equals/hashCode as needed.
PROS: Common behavior across all objects.
CONS: Must override methods for meaningful output.
*/
class Student {
    String name;

    Student(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Student name: " + name;
    }
}

// 4. ABSTRACTION
/*
TYPES:
1. Abstract Class (can have abstract + concrete methods)
2. Interface (all methods abstract by default in Java <8; can have default/static in Java 8+)

WHAT: Hiding implementation, showing only essentials.
WHY: To reduce complexity, improve design.
WHEN: Use abstract classes/interfaces.
HOW: 'abstract' keyword; interface with abstract methods.
RULES: Abstract class cannot be instantiated.
PROS: Cleaner API, flexible implementations.
CONS: Too many abstract layers = complexity.
*/
abstract class Shape {
    abstract void draw();
}
class Circle extends Shape {
    void draw() { System.out.println("Drawing Circle"); }
}
interface AnimalInterface {
    void speak();
}
class Cat implements AnimalInterface {
    public void speak() { System.out.println("Cat meows"); }
}

// 5. ENCAPSULATION
/*
WHAT: Binding data and methods, restricting access.
WHY: To protect fields from invalid access/modification.
WHEN: Always use with sensitive data.
HOW: Use private fields + getters/setters.
RULES: Fields private, provide public getters/setters.
PROS: Security, flexibility.
CONS: More boilerplate code.
*/
class BankAccount {
    private double balance;

    public double getBalance() { return balance; }
    public void deposit(double amount) { balance += amount; }
}

// 6. INHERITANCE
/*
TYPES in Java:
1. Single Inheritance → One class extends another.
2. Multilevel Inheritance → Class extends a derived class.
3. Hierarchical Inheritance → Multiple classes extend one base class.
(NOTE: Java does NOT support multiple inheritance with classes, but supports via interfaces.)

WHAT: Mechanism to acquire properties of another class.
WHY: Reuse code, establish relationships.
WHEN: Use "is-a" relationship.
HOW: 'extends' keyword.
RULES: Java supports single inheritance only.
PROS: Reusability, organized hierarchy.
CONS: Tight coupling, fragile if misused.
*/
class Animal {
    void sound() { System.out.println("Animal makes sound"); }
}
class Dog extends Animal { // Single
    void sound() { System.out.println("Dog barks"); }
}
class Puppy extends Dog { // Multilevel
    void sound() { System.out.println("Puppy yelps"); }
}
class Cat2 extends Animal { // Hierarchical
    void sound() { System.out.println("Cat meows"); }
}

// 7. POLYMORPHISM
/*
TYPES:
1. Compile-time (Method Overloading)
2. Runtime (Method Overriding)

WHAT: Ability of object to take many forms.
WHY: Flexibility, dynamic behavior.
WHEN: Method overriding/overloading.
HOW: Overloading (compile-time), Overriding (runtime).
RULES: Overloading → same name, different params. Overriding → same signature.
PROS: Code flexibility, extensibility.
CONS: Misuse may reduce clarity.
*/
class Calculator {
    int add(int a, int b) { return a + b; } // Overloading
    double add(double a, double b) { return a + b; }
}
class Bird {
    void fly() { System.out.println("Bird flies"); } // Overriding
}
class Eagle extends Bird {
    void fly() { System.out.println("Eagle soars high"); }
}

// 8. PACKAGES
/*
WHAT: Grouping classes/interfaces.
WHY: To organize large projects.
WHEN: For modular design.
HOW: 'package' keyword; 'import' to use.
RULES: Package name = lowercase; must match directory.
PROS: Encapsulation, modularity, reuse.
CONS: Adds complexity in small projects.
*/
// Example: package mypackage; (cannot show in same file, but assume in directory)

// ==========================
// MAIN CLASS TO RUN EXAMPLES
// ==========================
public class OOPConceptsDemo {
    public static void main(String[] args) {

        // Classes & Objects
        Car car = new Car();
        car.brand = "Tesla"; car.speed = 120;
        car.drive();

        // Constructors
        Point p1 = new Point();
        Point p2 = new Point(5, 10);
        Point p3 = new Point(p2);
        p1.display(); p2.display(); p3.display();

        // Object Class
        Student s = new Student("Alice");
        System.out.println(s.toString());

        // Abstraction - Abstract Class
        Shape shape = new Circle();
        shape.draw();

        // Abstraction - Interface
        AnimalInterface cat = new Cat();
        cat.speak();

        // Encapsulation
        BankAccount acc = new BankAccount();
        acc.deposit(500);
        System.out.println("Balance: " + acc.getBalance());

        // Inheritance
        Animal a = new Animal(); a.sound();
        Dog d = new Dog(); d.sound();
        Puppy pup = new Puppy(); pup.sound();
        Cat2 c = new Cat2(); c.sound();

        // Polymorphism - Overloading
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));
        System.out.println(calc.add(5.5, 10.5));

        // Polymorphism - Overriding
        Bird b = new Bird(); b.fly();
        Bird e = new Eagle(); e.fly();
    }
}

/*
==========================
EXPECTED OUTPUT
==========================
Tesla is driving at 120 km/h
Point: (0,0)
Point: (5,10)
Point: (5,10)
Student name: Alice
Drawing Circle
Cat meows
Balance: 500.0
Animal makes sound
Dog barks
Puppy yelps
Cat meows
15
16.0
Bird flies
Eagle soars high
*/

/*
==========================
SUMMARY
==========================
- CLASSES & OBJECTS: Blueprints + instances → reusability.
- CONSTRUCTORS: Types → default, parameterized, copy.
- OBJECT CLASS: Root of all → provides base methods.
- ABSTRACTION: Types → abstract class, interface.
- ENCAPSULATION: Protect fields → controlled access.
- INHERITANCE: Types → single, multilevel, hierarchical.
- POLYMORPHISM: Types → compile-time (overloading), runtime (overriding).
- PACKAGES: Organize code → modularity.
*/
