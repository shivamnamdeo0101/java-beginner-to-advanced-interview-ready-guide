package com.shivam.java_6_interfaces;
// ==========================
// JAVA INTERFACES: DEFAULT METHOD DIAMOND PROBLEM
// With WHAT, WHY, WHEN, HOW, RULES, PROS, CONS, Example + Output
// ==========================

// 1. WHAT
/*
- Default methods allow interfaces to have method implementations.
- Diamond problem occurs when a class implements multiple interfaces with the same default method signature.
- Java requires explicit overriding to resolve ambiguity.
*/

// 2. WHY
/*
- To provide backward compatibility (interfaces can have implementations from Java 8+)
- To enable multiple inheritance of behavior while avoiding ambiguity.
*/

// 3. WHEN
/*
- When a class implements two or more interfaces having the same default method.
- Example: PI1 and PI2 both have default show() method.
*/

// 4. HOW
/*
- Implement both interfaces in a class.
- Override the conflicting default method.
- Optionally, call specific interface's default using InterfaceName.super.method().
*/

// 5. RULES / NOTES
/*
- Must override default method if multiple interfaces define it.
- Use InterfaceName.super.method() to access a specific interface’s default.
- Otherwise, compilation error occurs.
*/

// 6. PROS
/*
- Provides reusable default behavior in interfaces.
- Multiple inheritance is possible safely.
- Resolves ambiguity explicitly.
*/

// 7. CONS
/*
- Too many conflicting defaults can become messy.
- Requires extra boilerplate to resolve conflicts.
*/

// ==========================
// EXAMPLE: DIAMOND PROBLEM RESOLUTION
// ==========================
interface PI1 {
    default void show() {
        System.out.println("Default PI1");
    }
}

interface PI2 {
    default void show() {
        System.out.println("Default PI2");
    }
}

// Class implements both interfaces
class DiamondProblem implements PI1, PI2 {

    // Must override show() to resolve conflict
    @Override
    public void show() {
        System.out.println("Overridden in DiamondProblem");

        // Call default methods from specific interfaces
        PI1.super.show();
        PI2.super.show();
    }

    public static void main(String[] args) {
        DiamondProblem obj = new DiamondProblem();
        obj.show();
    }
}

/*
==========================
EXPECTED OUTPUT
==========================
Overridden in TestClass
Default PI1
Default PI2
*/

/*
==========================
SUMMARY
==========================
- Default methods in interfaces help add implementations without breaking old code.
- Diamond problem occurs when multiple interfaces have same default method.
- Java requires explicit override to resolve ambiguity.
- Use InterfaceName.super.method() to access a specific interface's default method.
- Pros: Multiple inheritance safely, reusable code.
- Cons: Too many conflicts = messy overrides.
*/
