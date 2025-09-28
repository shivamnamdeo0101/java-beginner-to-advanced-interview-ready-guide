package com.shivam.interviewques;

public class SecretCodes  {
    public static void main(String[] args) {
        int[] codes = {404, 12, 504, 7, 414, 604, 700, 1};
        System.out.println(countPairs(codes)); // Output: 5
    }

    static int countPairs(int[] codes) {
        int n = codes.length;
        int totalPairs = 0;

        // Compare each pair (i, j) where i < j
        for (int i = 0; i < n; i++) {
            String a = String.valueOf(codes[i]);
            for (int j = i + 1; j < n; j++) {
                String b = String.valueOf(codes[j]);
                // Only compare if length is same
                if (a.length() != b.length()) continue;
                if (differsByOne(a, b)) totalPairs++;
            }
        }

        return totalPairs;
    }

    // Check if two codes differ by exactly one digit
    static boolean differsByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
