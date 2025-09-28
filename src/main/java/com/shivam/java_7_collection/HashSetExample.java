package com.shivam.java_7_collection;
// HashSet in Java internally uses HashMap
// hashCode() generates a numeric value for each object
// HashSet stores objects based on hashCode for O(1) access
import java.util.HashSet;

//Key Points:
//
//Only unique elements
//
//No ordering
//
//Average complexity O(1) for add, remove, contains
public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        // Add elements
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Duplicate ignored

        // Check if element exists
        System.out.println("Contains Banana? " + set.contains("Banana"));

        // Remove element
        set.remove("Apple");

        // Iterate over elements
        for (String item : set) {
            System.out.println(item);
        }
    }
}

