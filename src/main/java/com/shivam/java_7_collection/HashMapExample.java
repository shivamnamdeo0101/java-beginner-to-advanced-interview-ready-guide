package com.shivam.java_7_collection;
import java.util.HashMap;

/*

Key Points:

Keys are unique

Values can be duplicate

Order is not guaranteed

Average time complexity: O(1) for get, put, remove
 */

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Add elements
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        // Access value by key
        System.out.println("Apple value: " + map.get("Apple"));

        // Check if key exists
        System.out.println("Contains Banana? " + map.containsKey("Banana"));

        // Remove a key
        map.remove("Orange");

        // Iterate over keys and values
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
