//The Two Pointers pattern is highly effective on sorted arrays. We initialize a left pointer at the start and a right pointer at the end. We check their sum:
//
//If the sum equals the target, we're done.
//
//If the sum is less than the target, we need a larger value, so we increment left.
//
//If the sum is greater than the target, we need a smaller value, so we decrement right.
//This linear scan approach is O(n) time complexity.

package com.shivam.interviewques;

import java.util.Arrays;

public class Java_2_TwoPointerSumSortedArray {
    public static int [] twoSum(int [] arr, int target){
        int left = 0;
        int right = arr.length -1;
        int[] result = new int[0];
        while (left <= right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == target){
                result = new int[]{left, right};
//                left++;
//                right--;   need if last outer scope
            }else if(currentSum < target){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {11,12,13,14,15,16};
        int[] res = Java_2_TwoPointerSumSortedArray.twoSum(arr,25);
        System.out.println(Arrays.toString(res));
    }
}
