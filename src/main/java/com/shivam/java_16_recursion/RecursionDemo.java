package com.shivam.java_16_recursion;

public class RecursionDemo {
    public static void main(String[] args) {
        recurse(1);
    }

    static void recurse(int n) {
        int[] bigArray = new int[1000]; // 1000 ints = ~4KB
        System.out.println("Depth: " + n);
        recurse(n + 1);
    }
}


