package com.shivam.java_8_exception_handling;


// ==========================
// JAVA EXCEPTION HANDLING WITH METHOD OVERRIDING
// ==========================

/*
RULES:
Case 1: Subclass CANNOT declare a new or broader checked exception
        than the one declared by the superclass method.
Case 2: Subclass CAN declare a child exception of the superclass exception.
Case 3: Subclass CAN declare no exception at all (narrower).
*/

import java.io.*;

// Superclass
class Parent {
    void show() throws IOException {
        System.out.println("Parent: May throw IOException");
    }
}

// ==========================
// Case 1: Invalid
// ==========================
class Child1 extends Parent {
    // ❌ Compilation error → SQLException is not related to IOException
    // void show() throws SQLException { ... }
}

// ==========================
// Case 2: Valid (Child Exception)
// ==========================
class Child2 extends Parent {
    @Override
    void show() throws FileNotFoundException { // FileNotFoundException is a subclass of IOException
        System.out.println("Child2: May throw FileNotFoundException");
    }
}

// ==========================
// Case 3: Valid (No Exception)
// ==========================
class Child3 extends Parent {
    @Override
    void show() {
        System.out.println("Child3: No exception declared");
    }
}

// ==========================
// DEMO
// ==========================
public class MethodOverridingException {
    public static void main(String[] args) {
        Parent p;

        // Case 2 Demo
        p = new Child2();
        try {
            p.show();
        } catch (IOException e) {
            System.out.println("Caught: " + e);
        }

        // Case 3 Demo
        p = new Child3();
        try {
            p.show();
        } catch (IOException e) {
            System.out.println("Caught: " + e);
        }
    }
}

/*
==========================
EXPECTED OUTPUT
==========================
Child2: May throw FileNotFoundException
Child3: No exception declared

==========================
FLOW DESCRIPTION
==========================
1. Parent declares `throws IOException`.
2. Case 1 → Invalid (Child cannot declare SQLException → unrelated checked exception).
3. Case 2 → Valid (Child2 declares FileNotFoundException, a subclass of IOException).
4. Case 3 → Valid (Child3 declares no exception → narrower than parent).
5. Runtime calls overridden methods accordingly → prints messages.
*/
