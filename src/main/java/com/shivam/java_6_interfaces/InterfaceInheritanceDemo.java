package com.shivam.java_6_interfaces;
// ==========================
// JAVA INTERFACES & INHERITANCE
// With WHAT, WHY, WHEN, HOW, TYPES, RULES, PROS, CONS, Example + Output
// ==========================

import java.util.*;

// ==========================
// 1. WHAT
/*
- Interface: Abstract blueprint for classes to define behavior (CAN-DO relationship).
- Contains abstract methods, constants (public static final), default and static methods (Java 8+), private methods (Java 9+).
- Cannot be instantiated directly.
*/

// ==========================
// 2. WHY
/*
- Achieve abstraction and multiple inheritance.
- Enforce a contract on classes.
- Support loose coupling and polymorphism.
*/

// ==========================
// 3. WHEN
/*
- Multiple classes share behavior but have different implementations.
- Need multiple inheritance for functionality.
*/

// ==========================
// 4. HOW
/*
- Use 'interface' keyword.
- Implement interface in class using 'implements'.
- All abstract methods are public by default.
- Functional interface: exactly one abstract method, can be used with Lambda.
- Default, static, private methods allowed in modern Java.
*/

// ==========================
// 5. TYPES OF INTERFACES
/*
1. Normal Interface: Abstract methods.
2. Functional Interface: Single abstract method, used with lambda.
3. Nested Interface: Declared inside class or interface.
4. Marker Interface: No methods, signals property. When a class implements a marker interface,
it indicates to the system that it supports certain operations or features associated
 with that interface.
5. Comparator Interface: Custom sorting.
*/

// ==========================
// 6. EXAMPLES
// ==========================

// --- NORMAL INTERFACE ---
interface VehicleClass {
    void changeGear(int a);
    void speedUp(int a);
    void applyBrakes(int a);
}

class Bicycle implements VehicleClass {
    int speed, gear;
    public void changeGear(int newGear) { gear = newGear; }
    public void speedUp(int increment) { speed += increment; }
    public void applyBrakes(int decrement) { speed -= decrement; }
    void printStates() { System.out.println("Bicycle speed: " + speed + ", gear: " + gear); }
}

class BikeClass implements VehicleClass {
    int speed, gear;
    public void changeGear(int newGear) { gear = newGear; }
    public void speedUp(int increment) { speed += increment; }
    public void applyBrakes(int decrement) { speed -= decrement; }
    void printStates() { System.out.println("BikeClass speed: " + speed + ", gear: " + gear); }
}

// --- FUNCTIONAL INTERFACE ---
@FunctionalInterface
interface Calculator {
    int add(int a, int b);  // single abstract method
    default void hello() { System.out.println("Hello from Calculator"); } // optional default method
}

// --- NESTED INTERFACE ---
class Machine {
    interface Repairable { void repair(); }
}
class Robot implements Machine.Repairable {
    public void repair() { System.out.println("Robot repaired"); }
}

// --- MARKER INTERFACE ---
interface Trackable {}
class Package implements Trackable { String id; Package(String id) { this.id = id; } }

// --- COMPARATOR INTERFACE ---
class Employee {
    String name; int salary;
    Employee(String name, int salary) { this.name = name; this.salary = salary; }
    public String toString() { return name + " : " + salary; }
}
class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) { return e1.salary - e2.salary; }
}

// --- MULTIPLE INTERFACES IMPLEMENTATION ---
//Java Diamond Problem Similar Scenario while class Child extends Parent1, Parent2
// if both paren having same name method
//        GrandParent
//           /     \
//          /       \
//        Parent1      Parent2
//          \       /
//           \     /
//             Test

interface Add { int add(int a, int b); }
interface Sub { int sub(int a, int b); }
class Cal implements Add, Sub {
    public int add(int a,int b) { return a+b; }
    public int sub(int a,int b) { return a-b; }
}

// --- INTERFACE INHERITANCE ---
interface A { void method1(); void method2(); }
interface B extends A { void method3(); }
class GFG implements B {
    public void method1() { System.out.println("Method 1"); }
    public void method2() { System.out.println("Method 2"); }
    public void method3() { System.out.println("Method 3"); }
}

// ==========================
// 7. MAIN CLASS TO RUN EXAMPLES
// ==========================
public class InterfaceInheritanceDemo {
    public static void main(String[] args) {

        // VehicleClass Example
        Bicycle bicycle = new Bicycle();
        bicycle.changeGear(2); bicycle.speedUp(3); bicycle.applyBrakes(1);
        bicycle.printStates();

        BikeClass BikeClass = new BikeClass();
        BikeClass.changeGear(1); BikeClass.speedUp(4); BikeClass.applyBrakes(3);
        BikeClass.printStates();

        // Functional Interface Example
        Calculator calc = (a,b)->a+b;
        System.out.println("Sum: " + calc.add(5,10));
        calc.hello();

        // Nested Interface Example
        Machine.Repairable r = new Robot();
        r.repair();

        // Marker Interface Example
        Package p = new Package("PKG001");
        if(p instanceof Trackable) System.out.println("Package is trackable: " + p.id);

        // Comparator Interface Example
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 70000));
        employees.add(new Employee("Charlie", 60000));
        Collections.sort(employees, new SalaryComparator());
        System.out.println("Employees sorted by salary:");
        for(Employee e: employees) System.out.println(e);

        // Multiple Interface Example
        Cal cal = new Cal();
        System.out.println("Addition: " + cal.add(2,1));
        System.out.println("Subtraction: " + cal.sub(2,1));

        // Interface Inheritance Example
        GFG g = new GFG();
        g.method1(); g.method2(); g.method3();
    }
}

/*
EXPECTED OUTPUT:
Bicycle speed: 2, gear: 2
BikeClass speed: 1, gear: 1
Sum: 15
Hello from Calculator
Robot repaired
Package is trackable: PKG001
Employees sorted by salary:
Alice : 50000
Charlie : 60000
Bob : 70000
Addition: 3
Subtraction: 1
Method 1
Method 2
Method 3
*/

/*
==========================
SUMMARY
==========================
- Interface: Blueprint of behavior, cannot instantiate.
- Types: Normal, Functional, Nested, Marker, Comparator.
- Multiple inheritance possible via interface.
- Methods: abstract by default; default, static, private allowed in modern Java.
- Pros: Abstraction, multiple inheritance, polymorphism, loose coupling.
- Cons: Too many interfaces can complicate code; implementing all methods can be verbose.
*/

