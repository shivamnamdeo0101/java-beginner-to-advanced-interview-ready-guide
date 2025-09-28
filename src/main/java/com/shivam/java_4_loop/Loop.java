package com.shivam.java_4_loop;

// ==========================================================
// Java Loops Example with Explanations
// ==========================================================
// Types of Loops in Java:
// 1. for loop       → Exact iterations (entry-controlled)
// 2. while loop     → Repeat while condition true (entry-controlled)
// 3. do-while loop  → Executes at least once (exit-controlled)
// 4. for-each loop  → Iterate over collections/arrays easily
// ==========================================================

public class Loop {
    public static void main(String[] args) {

        // --------------------------------------------------
        // 1. FOR LOOP
        // --------------------------------------------------
        // ✅ When to use → If you know exactly how many times you want to run
        // ✅ Condition check → Before entering the loop (entry-controlled)
        // ✅ Executes at least once? → No, only if condition is true at start
        System.out.println("=== For Loop Example ===");
        for (int i = 1; i <= 5; i++) { // initialization → condition → increment
            System.out.println("For loop iteration: " + i);
        }

        // --------------------------------------------------
        // 2. WHILE LOOP
        // --------------------------------------------------
        // ✅ When to use → If number of iterations is NOT known in advance
        // ✅ Condition check → Before loop body (entry-controlled)
        // ✅ Executes at least once? → No, only if condition true
        System.out.println("\n=== While Loop Example ===");
        int j = 1;
        while (j <= 5) { // checks condition first
            System.out.println("While loop iteration: " + j);
            j++; // increment inside loop
        }

        // --------------------------------------------------
        // 3. DO-WHILE LOOP
        // --------------------------------------------------
        // ✅ When to use → If loop body MUST run at least once
        // ✅ Condition check → After loop body (exit-controlled)
        // ✅ Executes at least once? → YES (body runs before condition check)
        System.out.println("\n=== Do-While Loop Example ===");
        int k = 1;
        do {
            System.out.println("Do-While loop iteration: " + k);
            k++;
        } while (k <= 5); // condition checked AFTER body

        // --------------------------------------------------
        // 4. FOR-EACH LOOP
        // --------------------------------------------------
        // ✅ When to use → If you want to process each element in array/collection
        // ✅ Condition check → Internally handled by Java
        // ✅ Executes at least once? → No, only if collection has elements
        System.out.println("\n=== For-Each Loop Example ===");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int num : numbers) { // automatically picks elements
            System.out.println("For-each value: " + num);
        }
    }
}

