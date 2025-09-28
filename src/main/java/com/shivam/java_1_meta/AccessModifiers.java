package com.shivam.java_1_meta;

// ==========================================================
// Java Example: Access Modifiers
// ==========================================================
// Access Modifiers control the *visibility* of classes, methods, and variables.
//
// Types:
// 1. public    → Accessible from anywhere
// 2. private   → Accessible only within the same class
// 3. protected → Accessible in same package + subclasses (even in other packages)
// 4. default   → (no modifier) Accessible only within the same package
// ==========================================================

// ----------------------------------------------------------
// Class with different access modifiers
// ----------------------------------------------------------
class Animal {

    // 1️⃣ public variable → accessible from anywhere
    public String type = "Mammal";

    // 2️⃣ private variable → accessible only inside this class
    private String secretName = "PrivateLion";

    // 3️⃣ protected variable → accessible within package + subclasses
    protected String sound = "Roar";

    // 4️⃣ default (package-private) variable → accessible only in same package
    String color = "Brown";

    // ----------------------------
    // public method
    // ----------------------------
    public void showType() {
        System.out.println("Public Method: Animal type = " + type);
    }

    // ----------------------------
    // private method
    // ----------------------------
    private void showSecret() {
        System.out.println("Private Method: Secret name = " + secretName);
    }

    // ----------------------------
    // protected method
    // ----------------------------
    protected void makeSound() {
        System.out.println("Protected Method: Sound = " + sound);
    }

    // ----------------------------
    // default (package-private) method
    // ----------------------------
    void showColor() {
        System.out.println("Default Method: Color = " + color);
    }

    // Method inside same class → can access everything
    public void testAccessInsideClass() {
        System.out.println("Inside Animal Class: Can access ALL members");
        System.out.println(type);         // ✅ public
        System.out.println(secretName);   // ✅ private
        System.out.println(sound);        // ✅ protected
        System.out.println(color);        // ✅ default
        showSecret();                     // ✅ private method accessible here
    }
}

// ----------------------------------------------------------
// Subclass in SAME PACKAGE
// ----------------------------------------------------------
class Dog extends Animal {
    public void accessFromSubclass() {
        System.out.println("\n--- Inside Dog (Subclass, same package) ---");
        System.out.println(type);     // ✅ public
        // System.out.println(secretName); // ❌ private not accessible
        System.out.println(sound);    // ✅ protected accessible in subclass
        System.out.println(color);    // ✅ default accessible (same package)
        makeSound();                  // ✅ protected method
    }
}

// ----------------------------------------------------------
// Another class in SAME PACKAGE (not a subclass)
// ----------------------------------------------------------
class Cat {
    public void accessFromNonSubclass() {
        Animal a = new Animal();
        System.out.println("\n--- Inside Cat (Non-subclass, same package) ---");
        System.out.println(a.type);   // ✅ public
        // System.out.println(a.secretName); // ❌ private not accessible
        System.out.println(a.sound);  // ✅ protected accessible (same package)
        System.out.println(a.color);  // ✅ default accessible (same package)
    }
}

// ==========================================================
// Main Class (Entry Point)
// ==========================================================
public class AccessModifiers {
    public static void main(String[] args) {
        Animal animal = new Animal();

        System.out.println("\n--- Accessing from Main ---");
        System.out.println(animal.type);   // ✅ public
        // System.out.println(animal.secretName); // ❌ private not accessible
        System.out.println(animal.sound);  // ✅ protected (same package)
        System.out.println(animal.color);  // ✅ default (same package)

        animal.showType();      // ✅ public
        // animal.showSecret(); // ❌ private not accessible
        animal.makeSound();     // ✅ protected
        animal.showColor();     // ✅ default
        animal.testAccessInsideClass(); // ✅ can access everything internally

        Dog dog = new Dog();
        dog.accessFromSubclass(); // Subclass access

        Cat cat = new Cat();
        cat.accessFromNonSubclass(); // Non-subclass same package
    }
}
