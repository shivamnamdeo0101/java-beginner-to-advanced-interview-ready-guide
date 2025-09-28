package com.shivam.java_6_interfaces;


// ==========================
// JAVA CLASS vs INTERFACE
// With WHAT, WHY, WHEN, HOW, RULES, PROS, CONS, Example + Output
// ==========================

// 1. WHAT
/*
- Class: A blueprint for objects; defines state (fields) and behavior (methods).
- Interface: A blueprint for behavior; defines methods that implementing classes must provide.
*/

// 2. WHY
/*
- Classes: Represent real-world entities with attributes and behavior.
- Interfaces: Enforce a contract for behavior; allow multiple inheritance of behavior.
*/

// 3. WHEN
/*
- Use Class: When creating objects with specific states and actions.
- Use Interface: When multiple classes share behavior but have different implementations.
*/

// 4. HOW
/*
- Class: defined using 'class', instantiated with 'new', can extend one class, implement multiple interfaces.
- Interface: defined using 'interface', cannot be instantiated directly, implemented with 'implements', can extend multiple interfaces.
*/

// 5. RULES / NOTES
/*
- Class can have constructors; interface cannot.
- Class variables: any type; Interface variables: public static final by default.
- Class methods: any access + concrete or abstract; Interface methods: public abstract by default (default/static allowed in Java 8+).
*/

// 6. PROS
/*
- Class: Encapsulates state + behavior, reusable.
- Interface: Provides abstraction, supports multiple inheritance, loose coupling.
*/

// 7. CONS
/*
- Class: Cannot inherit multiple classes.
- Interface: Too many interfaces = complex, must implement all abstract methods.
*/

// ==========================
// EXAMPLE: CLASS
// ==========================
class Dog {

    private String name;
    private String breed;
    private int age;
    private String color;

    // Constructor
    public Dog(String name, String breed, int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    // Getters
    public String getName() { return name; }
    public String getBreed() { return breed; }
    public int getAge() { return age; }
    public String getColor() { return color; }

    // toString override
    @Override
    public String toString() {
        return "Name: " + name + "\nBreed, Age, Color: " + breed + ", " + age + ", " + color;
    }

    public static void main(String[] args) {
        Dog d = new Dog("Tuffy", "Papillon", 5, "White");
        System.out.println(d);
    }
}
/*
Output:
Name: Tuffy
Breed, Age, Color: Papillon, 5, White
*/

// ==========================
// EXAMPLE: INTERFACE
// ==========================
interface In1 {
    final int a = 10;          // public static final by default
    void display();             // public abstract by default
}

class ClassInterface implements In1 {
    @Override
    public void display() {
        System.out.println("Geek");
    }

    public static void main(String[] args) {
        ClassInterface t = new ClassInterface();
        t.display();
        System.out.println(a);
    }
}
/*
Output:
Geek
10
*/

// ==========================
// CLASS vs INTERFACE COMPARISON
// ==========================
/*
Feature           Class                        Interface
--------------------------------------------------------------
Keyword           class                        interface
Instantiation     Can create objects          Cannot create objects
Inheritance       Single inheritance only     Multiple inheritance supported
Methods           Concrete/Abstract           Abstract by default, default/static allowed (Java 8+)
Variables         Any type                    public static final by default
Constructors      Yes                          No
Access Specifier  public/private/protected     public by default
Purpose           Blueprint for objects       Contract for behavior
*/

