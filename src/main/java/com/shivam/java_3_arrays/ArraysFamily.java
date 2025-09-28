package com.shivam.java_3_arrays;

// ==========================================================
// ARRAYS in Java
// ==========================================================
// 🔹 WHAT:
// An array is a container object that holds a fixed number of
// elements of a single type.
// Indexing starts from 0.
//
// 🔹 FAMILY TYPES of Arrays:
// 1. One-Dimensional (1D Array)
// 2. Two-Dimensional (2D Array → Matrix)
// 3. Multi-Dimensional (3D and above)
// 4. Jagged Array (array of arrays with different sizes)
// 5. Array of Objects
//
// 🔹 PRONUNCIATION (PRON):
// - 1D Array → "One Dee Array"
// - 2D Array → "Two Dee Array" or "Matrix"
// - 3D Array → "Three Dee Array" (Cube)
// - Jagged Array → "Jagged Array" (irregular matrix)
//
// 🔹 PROS:
// - Fast access (O(1) indexing)
// - Simple to use for fixed-size data
// - Memory efficient compared to Collections
//
// 🔹 CONS:
// - Fixed size (cannot grow/shrink dynamically)
// - Insert/Delete costly (O(n))
// - Type specific (no mixed data types)
//
// ==========================================================

public class ArraysFamily {
    public static void main(String[] args) {
        // -----------------------------------------------
        // 1. ONE-DIMENSIONAL ARRAY
        // -----------------------------------------------
        int[] arr1D = {10, 20, 30, 40, 50};
        System.out.println("=== 1D Array ===");
        for (int i = 0; i < arr1D.length; i++) {
            System.out.println("Index " + i + " = " + arr1D[i]);
        }

        // -----------------------------------------------
        // 2. TWO-DIMENSIONAL ARRAY (Matrix)
        // -----------------------------------------------
        int[][] arr2D = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("\n=== 2D Array (Matrix) ===");
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println();
        }

        // -----------------------------------------------
        // 3. MULTI-DIMENSIONAL ARRAY (3D)
        // -----------------------------------------------
        int[][][] arr3D = {
                { {1, 2}, {3, 4} },
                { {5, 6}, {7, 8} }
        };
        System.out.println("\n=== 3D Array (Cube) ===");
        for (int i = 0; i < arr3D.length; i++) {
            for (int j = 0; j < arr3D[i].length; j++) {
                for (int k = 0; k < arr3D[i][j].length; k++) {
                    System.out.print(arr3D[i][j][k] + " ");
                }
                System.out.println();
            }
        }

        // -----------------------------------------------
        // 4. JAGGED ARRAY (irregular rows)
        // -----------------------------------------------
        int[][] jaggedArr = new int[3][]; // outer array of size 3
        jaggedArr[0] = new int[2]; // first row length = 2
        jaggedArr[1] = new int[4]; // second row length = 4
        jaggedArr[2] = new int[3]; // third row length = 3

        // Fill values
        int val = 1;
        for (int i = 0; i < jaggedArr.length; i++) {
            for (int j = 0; j < jaggedArr[i].length; j++) {
                jaggedArr[i][j] = val++;
            }
        }

        System.out.println("\n=== Jagged Array ===");
        for (int i = 0; i < jaggedArr.length; i++) {
            for (int j = 0; j < jaggedArr[i].length; j++) {
                System.out.print(jaggedArr[i][j] + " ");
            }
            System.out.println();
        }

        // -----------------------------------------------
        // 5. ARRAY OF OBJECTS
        // -----------------------------------------------
        String[] fruits = new String[3];
        fruits[0] = "Apple";
        fruits[1] = "Banana";
        fruits[2] = "Cherry";

        System.out.println("\n=== Array of Objects ===");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

