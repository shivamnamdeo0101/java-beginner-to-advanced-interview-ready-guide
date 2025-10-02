package com.shivam.java_11_stream_and_lamda;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamAndLambda{
    public static void main(String[] args) {

        /* =========================================================
         * 1. LAMBDA EXPRESSIONS
         * =========================================================
         */

        System.out.println("===== LAMBDA EXPRESSIONS =====");

        // WHAT: Anonymous function implementing a functional interface
        Runnable r = () -> System.out.println("Lambda Runnable running...");

        // WHY: Avoids boilerplate of anonymous inner classes
        r.run();

        // WHEN: Useful for functional interfaces like Runnable, Comparator, Predicate
        @FunctionalInterface
        interface FuncInterface {
            void abstractFun(int x);
        }

        // HOW: (param) -> expression
        FuncInterface fobj = (int x) -> System.out.println("Double: " + (2 * x));
        fobj.abstractFun(10);

        // RULES: Target must be functional interface (1 abstract method)
        List<String> names = Arrays.asList("Shivam", "Aman", "Riya", "Ankit");
        Collections.sort(names, (a, b) -> a.compareTo(b));

        // PROS: Concise, readable
        // CONS: Debugging harder
        System.out.println("Sorted with Lambda: " + names);


        /* =========================================================
         * 2. METHOD REFERENCES
         * =========================================================
         */

        System.out.println("\n===== METHOD REFERENCES =====");

        // WHAT: Shortcut for calling existing methods
        // WHY: Cleaner than writing lambda calling only one method

        // HOW: Class::staticMethod, obj::instanceMethod, Class::instanceMethod, Class::new
        List<Integer> nums = Arrays.asList(5, 1, 3, 2, 4);

        // Static Method Ref
        nums.forEach(System.out::print);
        System.out.println("  <-- System.out::print");

        // Instance Method Ref
        Collections.sort(names, String::compareToIgnoreCase);
        System.out.println("Sorted with Method Ref: " + names);

        // Constructor Ref
        Supplier<StringBuilder> sbSupplier = StringBuilder::new;
        StringBuilder sb = sbSupplier.get().append("Hello from Constructor Ref!");
        System.out.println(sb);

        // RULES: Signature of method reference must match functional interface
        // PROS: More concise than lambda
        // CONS: Less flexible (only direct method call)


        /* =========================================================
         * 3. STREAMS
         * =========================================================
         */

        System.out.println("\n===== STREAMS =====");

        // WHAT: Sequence of elements supporting functional-style ops
        // WHY: Declarative, readable, supports parallelism
        // WHEN: Use with collections/arrays
        // WHERE: Large data sets, functional transformations

        // HOW: Source → Intermediate ops → Terminal op
        List<Integer> squares = nums.stream()
                .filter(n -> n % 2 == 0)   // Intermediate: filter
                .map(n -> n * n)           // Intermediate: map
                .collect(Collectors.toList()); // Terminal: collect
        System.out.println("Squares of even numbers: " + squares);

        // Example: distinct + sorted
        List<Integer> list = Arrays.asList(5, 10, 20, 10, 30, 40);
        list.stream()
                .filter(n -> n > 10)
                .map(n -> n * 2)
                .distinct()
                .sorted()
                .forEach(n -> System.out.print(n + " "));
        System.out.println("  <-- Distinct + Sorted pipeline");

        // Reduce example
        int sum = nums.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum using reduce: " + sum);

        // Collectors
        Set<String> uniqueNames = names.stream().collect(Collectors.toSet());
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println("Unique names: " + uniqueNames);
        System.out.println("Joined names: " + joined);

        // Matching ops
        boolean anyStartsWithA = names.stream().anyMatch(s -> s.startsWith("A"));
        boolean allShort = names.stream().allMatch(s -> s.length() < 10);
        System.out.println("Any name starts with A? " + anyStartsWithA);
        System.out.println("All names < 10 chars? " + allShort);

        // Parallel Stream
        long evenCount = IntStream.range(1, 1_000_000)
                .parallel()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Even count (1–1,000,000): " + evenCount);

        // Infinite Stream
        System.out.print("First 5 naturals: ");
        Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Primitive Stream
        int sumSquares = IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .sum();
        System.out.println("Sum of squares 1–5: " + sumSquares);

        // RULES: Streams consumed once, intermediate lazy, terminal triggers
        // PROS: Concise, functional style, parallelism
        // CONS: Debugging tricky, overuse harms clarity
    }
}
