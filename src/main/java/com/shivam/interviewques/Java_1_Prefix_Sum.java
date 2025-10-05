package com.shivam.interviewques;

//1. Prefix Sum
//Question
//Given an array of integers nums, find the sum of elements between indices i and j (inclusive), where i≤j. Implement a class NumArray that can handle multiple such queries efficiently.

import java.util.Arrays;

class NumArray {
    int[] preFixSum;

    NumArray(int[] nums) {
        preFixSum = new int[nums.length + 1];
        preFixSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            preFixSum[i + 1] = preFixSum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return preFixSum[j + 1] - preFixSum[i];
    }

}

public class Java_1_Prefix_Sum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        NumArray numArray = new NumArray(arr);
        int sum = numArray.sumRange(0, 2);
        System.out.println("Sum of 0,2 for " + Arrays.toString(arr) + " sum : " + sum);
    }
}