package com.shivam.interviewques;

public class SubsequenceSum {
    // Recursive function to count subsequences with given sum
    public static int countSubseqSum(int[] arr, int index, int target) {
        if (index == arr.length) {
            return (target == 0) ? 1 : 0; // If target achieved, count 1
        }
        // Include current element
        int include = countSubseqSum(arr, index + 1, target - arr[index]);
        // Exclude current element
        int exclude = countSubseqSum(arr, index + 1, target);
        return include + exclude;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 3;
        System.out.println("Subsequences with sum " + target + ": " + countSubseqSum(arr, 0, target));
    }
}
