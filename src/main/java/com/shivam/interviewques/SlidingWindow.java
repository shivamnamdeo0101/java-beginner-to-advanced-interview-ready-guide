package com.shivam.interviewques;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {

    // Function to check sliding window for peaks and valleys
    public static List<Integer> slidingWindowPeakValley(int[] arr) {
        List<Integer> result = new ArrayList<>();

        // Slide window of size 3
        for (int i = 0; i <= arr.length - 3; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            int c = arr[i + 2];

            // Check for peak (a < b > c) or valley (a > b < c)
            if ((a < b && b > c) || (a > b && b < c)) {
                result.add(1); // Peak or valley found
            } else {
                result.add(0); // No peak or valley
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 4, 1, 5, 2};
        int[] arr = {1,2,1,3,4};

        List<Integer> output = slidingWindowPeakValley(arr);

        System.out.println(output); // Output: [1, 1, 1, 1, 1]
    }
}
