package com.shivam.java_3_arrays;

// ==========================================================
// ARRAYS CLASS in Java
// ==========================================================
// 🔹 WHAT:
// The Arrays class (java.util.Arrays) is a utility class that provides
// static methods to manipulate arrays (sorting, searching, comparing, etc.)
//
// 🔹 WHY:
// Instead of manually writing sorting, searching, copying code →
// Arrays class provides ready-to-use methods.
//
// 🔹 HOW:
// import java.util.Arrays; and call methods as Arrays.methodName(...)
//
// 🔹 PROS:
// - Saves time (built-in efficient implementations).
// - Cleaner, less error-prone code.
// - Supports generics, objects, and primitives.
//
// 🔹 CONS:
// - Works only with arrays, not ArrayList directly.
// ==========================================================

// Java program to demonstrate all important methods of Arrays class
// Arrays class is present in java.util package and provides many utility methods
// for performing operations on arrays like searching, sorting, comparing, etc.

import java.util.*;

public class ArraysClassDemo {
    public static void main(String[] args) {

        // Sample arrays
        int[] arr = {10, 20, 30, 40, 50};
        int[] arr2 = {10, 20, 30, 40, 50};
        int[] arr3 = {10, 25, 30, 40, 55};

        String[][] deepArr1 = {{"A", "B"}, {"C", "D"}};
        String[][] deepArr2 = {{"A", "B"}, {"C", "D"}};

        // 1. asList() - Returns a fixed-size list backed by the array
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("asList(): " + list);

        // 2. binarySearch() - Search element using binary search
        int index = Arrays.binarySearch(arr, 30);
        System.out.println("binarySearch(30): " + index);

        // 3. compare() - Compare two arrays lexicographically
        System.out.println("compare(arr, arr2): " + Arrays.compare(arr, arr2));
        System.out.println("compare(arr, arr3): " + Arrays.compare(arr, arr3));

        // 4. copyOf() - Copy entire array to new length
        int[] copyArr = Arrays.copyOf(arr, 7);
        System.out.println("copyOf(): " + Arrays.toString(copyArr));

        // 5. copyOfRange() - Copy a specific range
        int[] rangeArr = Arrays.copyOfRange(arr, 1, 4);
        System.out.println("copyOfRange(1,4): " + Arrays.toString(rangeArr));

        // 6. deepEquals() - Compare multi-dimensional arrays deeply
        System.out.println("deepEquals(): " + Arrays.deepEquals(deepArr1, deepArr2));

        // 7. deepHashCode() - Hash code based on deep contents
        System.out.println("deepHashCode(): " + Arrays.deepHashCode(deepArr1));

        // 8. deepToString() - Deep string representation
        System.out.println("deepToString(): " + Arrays.deepToString(deepArr1));

        // 9. equals() - Compare 1D arrays
        System.out.println("equals(arr, arr2): " + Arrays.equals(arr, arr2));

        // 10. fill() - Fill entire array with value
        int[] fillArr = new int[5];
        Arrays.fill(fillArr, 99);
        System.out.println("fill(): " + Arrays.toString(fillArr));

        // 11. hashCode() - Returns hashCode for array
        System.out.println("hashCode(arr): " + Arrays.hashCode(arr));

        // 12. mismatch() - Returns first mismatched index
        System.out.println("mismatch(arr, arr3): " + Arrays.mismatch(arr, arr3));

        // 13. parallelPrefix() - Applies cumulative function in parallel
        int[] prefixArr = {1, 2, 3, 4, 5};
        Arrays.parallelPrefix(prefixArr, (x, y) -> x + y);
        System.out.println("parallelPrefix(): " + Arrays.toString(prefixArr));

        // 14. parallelSetAll() - Sets elements using lambda in parallel
        int[] setArr = new int[5];
        Arrays.parallelSetAll(setArr, i -> i * i); // squares of indices
        System.out.println("parallelSetAll(): " + Arrays.toString(setArr));

        // 15. parallelSort() - Sorts using multiple threads
        int[] unsorted = {5, 3, 8, 1, 9};
        Arrays.parallelSort(unsorted);
        System.out.println("parallelSort(): " + Arrays.toString(unsorted));

        // 16. setAll() - Sets values using generator
        int[] genArr = new int[5];
        Arrays.setAll(genArr, i -> i + 100); // index + 100
        System.out.println("setAll(): " + Arrays.toString(genArr));

        // 17. sort() - Sorts array
        int[] sortArr = {9, 2, 6, 3, 7};
        Arrays.sort(sortArr);
        System.out.println("sort(): " + Arrays.toString(sortArr));

        // 18. spliterator() - Splits array for parallel processing
        Spliterator<Integer> spl = Arrays.spliterator(new Integer[]{1, 2, 3, 4});
        System.out.print("spliterator(): ");
        spl.forEachRemaining(System.out::print);
        System.out.println();

        // 19. stream() - Convert array to Stream
        int sum = Arrays.stream(arr).sum();
        System.out.println("stream() sum: " + sum);

        // 20. toString() - Array as string
        System.out.println("toString(): " + Arrays.toString(arr));
    }
}

/*
🔑 Key Notes:

- Arrays class provides only static methods.
- Used for utility operations like sorting, searching, copying, comparing, etc.
- For primitive arrays -> equals(), toString(), sort()
- For multidimensional arrays -> deepEquals(), deepToString(), deepHashCode()
- For parallel performance -> parallelSort(), parallelPrefix(), parallelSetAll()

*/
