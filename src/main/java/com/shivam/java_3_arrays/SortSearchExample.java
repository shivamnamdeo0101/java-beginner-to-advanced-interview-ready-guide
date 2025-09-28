package com.shivam.java_3_arrays;

import java.util.Arrays;

public class SortSearchExample {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};

        // Sorting
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Searching (binary search)
        int key = 3;
        int index = Arrays.binarySearch(arr, key);
        System.out.println("Index of " + key + ": " + index);
    }
}

