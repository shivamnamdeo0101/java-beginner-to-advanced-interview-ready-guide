package com.shivam.java_1_meta;

// ==========================================================
// Java Variable Arguments (Varargs)
// ==========================================================
// 🔹 What: Varargs (variable arguments) let you pass multiple arguments
//           of the same type to a method without defining them separately.
//
// 🔹 Why: Instead of writing multiple overloaded methods for different
//           numbers of arguments, varargs provide a simpler way.
//
// 🔹 How: Use `...` (triple dots) after the data type in method parameter.
//          Example: void printNumbers(int... nums)
//
// 🔹 When: Use varargs when the number of arguments is not fixed.
//          Example: Math.max(), printf() internally use varargs.
//
// 🔹 Rule:
//    1. Only ONE varargs parameter allowed in a method.
//    2. It must be the LAST parameter in the method.
// ==========================================================

public class VarargsExample {

    // Method with varargs → accepts 0 or more int values
    public static void sumNumbers(int... numbers) {
        int sum = 0;

        // internally, varargs = array
        for (int num : numbers) {
            sum += num;
        }

        System.out.println("Sum = " + sum);
    }

    // Method with normal + varargs parameter
    public static void greet(String message, String... names) {
        // message is normal param, names is varargs (array of Strings)
        System.out.print(message + " ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println(); // new line
    }

    public static void main(String[] args) {

        System.out.println("=== Varargs Examples ===");

        // 1. Passing multiple numbers
        sumNumbers(10, 20, 30, 40); // → Sum = 100

        // 2. Passing single number
        sumNumbers(5); // → Sum = 5

        // 3. Passing no number
        sumNumbers(); // → Sum = 0

        // 4. Greeting multiple people
        greet("Hello,", "Shivam", "Rahul", "Neha");
        // → Hello, Shivam Rahul Neha

        // 5. Greeting single person
        greet("Hi,", "Amit");
        // → Hi, Amit

        // 6. Greeting with no names
        greet("Good Morning,");
        // → Good Morning,
    }
}

