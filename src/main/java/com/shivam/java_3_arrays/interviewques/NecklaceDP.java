package com.shivam.java_3_arrays.interviewques;

public class NecklaceDP {
    // Count number of increasing sequences of length n from start to end
    public static int countNecklaces(int start, int end, int n) {
        if (n == 0) return 1; // Base case: no more beads left
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += countNecklaces(i + 1, end, n - 1); // recursive DP
        }
        return count;
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 50;
        int length = 3; // number of beads
        System.out.println("Number of possible necklaces: " + countNecklaces(start, end, length));
    }
}

