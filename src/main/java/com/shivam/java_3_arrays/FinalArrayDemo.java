package com.shivam.java_3_arrays;

// ==========================================================
// FINAL ARRAYS & FINAL OBJECTS in Java
// ==========================================================
// 🔹 WHAT:
// - `final` keyword in Java can be applied to variables (primitive or reference).
// - For arrays or objects, `final` means the **reference cannot be changed**,
//   but the **contents of the array or state of the object can be modified**.
//
// 🔹 RULES:
// 1. Modify elements in final array → Allowed
// 2. Reassign final array → Not allowed
// 3. Modify object state in final object → Allowed
// 4. Reassign final object reference → Not allowed
// ==========================================================

import java.util.Arrays;

class FinalArrayDemo {
    public static void main(String[] args) {

        // 1. Final array
        final int[] numbers = {1, 2, 3};

        System.out.println("Original array: " + Arrays.toString(numbers));

        // ✅ Modify element in final array → Allowed
        numbers[0] = 10;
        System.out.println("After modifying element: " + Arrays.toString(numbers));

        // ❌ Reassign final array → Not allowed
        // numbers = new int[]{4, 5, 6}; // ❌ Compile-time error

        // 2. Final object
        final Person person = new Person("Shivam", 25);

        System.out.println("Original Person: " + person);

        // ✅ Modify object state → Allowed
        person.age = 26;
        System.out.println("After modifying object state: " + person);

        // ❌ Reassign final object reference → Not allowed
        // person = new Person("Rahul", 30); // ❌ Compile-time error
    }
}

// Simple Person class
class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

/*
✅ Summary Table:

Operation                           | Allowed? | Explanation
------------------------------------|----------|------------------------------------------
Modify element in final array        | Yes      | Array contents are mutable.
Reassign final array to new array    | No       | Reference is final; cannot point to new array.
Modify object state in final object  | Yes      | Object fields can be updated.
Reassign final object reference      | No       | Final variable cannot point to new instance.
*/

