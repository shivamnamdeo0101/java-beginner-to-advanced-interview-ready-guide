package com.shivam.interviewques;

public class Java_3_LongestSubarraySumLEK {
    public static int longestSubarray(int[] nums, int k) {
        int left = 0, sum = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Shrink window while sum > k
            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 2, 4, 1};
        int k = 7;
        System.out.println(longestSubarray(nums, k));  // Output: 3
    }
}
