
package com.shivam.java_11_stream_and_lamda;

import java.time.*;
        import java.util.*;
        import java.util.function.*;
        import java.util.stream.*;

public class Java8Feature {
    public static void main(String[] args) {

        /* =========================================================
         * 1. LAMBDA EXPRESSIONS
         * =========================================================
         */
        System.out.println("===== 1. LAMBDA EXPRESSIONS =====");

        // WHAT: Anonymous function implementing functional interface
        Runnable r = () -> System.out.println("Lambda Runnable running...");
        r.run();

        // WHY: Shorter, cleaner code
        // WHEN: Use for functional interfaces (Runnable, Comparator)
        List<String> names = Arrays.asList("Shivam", "Aman", "Riya", "Ankit");
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("Sorted with Lambda: " + names);

        // HOW: (params) -> expression or (params) -> { statements }
        Consumer<Integer> printer = x -> System.out.println("Square: " + (x * x));
        printer.accept(5);


        /* =========================================================
         * 2. FUNCTIONAL INTERFACES
         * =========================================================
         */
        System.out.println("\n===== 2. FUNCTIONAL INTERFACES =====");

        // WHAT: Interface with only one abstract method
        // WHY: Foundation of Lambda Expressions
        // WHEN: Use built-in ones from java.util.function

        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println("Does Aman start with A? " + startsWithA.test("Aman"));

        Function<Integer, Integer> doubler = n -> n * 2;
        System.out.println("Double of 7 = " + doubler.apply(7));

        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random number: " + randomSupplier.get());

        BiConsumer<String, Integer> printer2 =
                (s, i) -> System.out.println(s + " is " + i + " years old");
        printer2.accept("Shivam", 25);


        /* =========================================================
         * 3. METHOD REFERENCES
         * =========================================================
         */
        System.out.println("\n===== 3. METHOD REFERENCES =====");

        // WHAT: Short form of lambda calling an existing method
        List<Integer> nums = Arrays.asList(5, 1, 3, 2, 4);

        nums.forEach(System.out::print); // Static Method Ref
        System.out.println("  <-- System.out::print");

        Collections.sort(names, String::compareToIgnoreCase);
        System.out.println("Sorted with Method Ref: " + names);

        Supplier<StringBuilder> sbSupplier = StringBuilder::new;
        System.out.println(sbSupplier.get().append("Hello from Constructor Ref!"));


        /* =========================================================
         * 4. STREAMS
         * =========================================================
         */
        System.out.println("\n===== 4. STREAMS =====");

        // WHAT: Pipeline for processing data
        List<Integer> squares = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares of even numbers: " + squares);

        int sum = nums.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum using reduce: " + sum);

        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println("Joined names: " + joined);


        /* =========================================================
         * 5. COMPARABLE & COMPARATOR
         * =========================================================
         */
        System.out.println("\n===== 5. COMPARABLE & COMPARATOR =====");

        class Student implements Comparable<Student> {
            String name;
            int age;
            Student(String n, int a) { name = n; age = a; }
            public int compareTo(Student s) { return this.age - s.age; }
            public String toString() { return name + "(" + age + ")"; }
        }

        List<Student> students = Arrays.asList(
                new Student("Shivam", 25),
                new Student("Aman", 22),
                new Student("Riya", 24)
        );

        Collections.sort(students); // Comparable
        System.out.println("Sorted by age (Comparable): " + students);

        students.sort((s1, s2) -> s1.name.compareTo(s2.name)); // Comparator
        System.out.println("Sorted by name (Comparator): " + students);


        /* =========================================================
         * 6. OPTIONAL CLASS
         * =========================================================
         */
        System.out.println("\n===== 6. OPTIONAL CLASS =====");

        // WHAT: Container for nullable values
        Optional<String> opt = Optional.ofNullable("Hello Optional");

        // WHY: Avoid NullPointerException
        System.out.println(opt.orElse("Default Value"));

        // HOW: ifPresent
        opt.ifPresent(val -> System.out.println("Value is: " + val));


        /* =========================================================
         * 7. DATE/TIME API
         * =========================================================
         */
        System.out.println("\n===== 7. DATE/TIME API =====");

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zoned = ZonedDateTime.now();

        System.out.println("Today: " + today);
        System.out.println("Now: " + now);
        System.out.println("DateTime: " + dateTime);
        System.out.println("ZonedDateTime: " + zoned);

        Period period = Period.between(LocalDate.of(2020, 1, 1), today);
        System.out.println("Period since 2020-01-01: " + period.getYears() + " years");


        /* =========================================================
         * 8. OTHER FEATURES (Interface & Collection Enhancements)
         * =========================================================
         */
        System.out.println("\n===== 8. OTHER FEATURES =====");

        // Default method in Interface
        interface MyInterface {
            default void greet() {
                System.out.println("Hello from Default Method in Interface!");
            }
        }
        class Impl implements MyInterface {}
        new Impl().greet();

        // forEach() on collection
        Arrays.asList("A", "B", "C").forEach(System.out::println);

        // removeIf()
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf (remove evens): " + list);
    }
}

