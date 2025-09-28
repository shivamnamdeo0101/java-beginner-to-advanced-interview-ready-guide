package com.shivam.interviewques;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Solves the Bird's Nest stick collection problem.
 * The bird collects sticks (non-zero values) from the forest array
 * by alternating directions (Right then Left) until a total length of 100 is reached.
 */
public class TheBirdsNest {

    /**
     * Simulates the bird's stick collection process.
     *
     * @param forest The array representing the forest (stick lengths, 0 for empty).
     * @param bird The bird's initial 0-based position in the forest.
     * @return A List of integers representing the 0-based indices of the sticks found,
     * in the order they were found.
     */
    public List<Integer> solution(int[] forest, int bird) {
        // Use a List to store the indices of the found sticks, as the size is unknown.
        List<Integer> foundStickIndices = new ArrayList<>();

        // Tracks the total length of sticks collected for the nest.
        int totalLength = 0;

        // Tracks the direction: true for RIGHT (i > bird), false for LEFT (i < bird).
        // Starts flying to the right according to step 1.
        boolean flyRight = true;

        // Loop until the total collected length reaches or exceeds 100.
        while (totalLength < 100) {

            int foundIndex = -1;

            if (flyRight) {
                // 1. FLY RIGHT: Check indices i > bird
                for (int i = bird + 1; i < forest.length; i++) {
                    if (forest[i] > 0) {
                        foundIndex = i;
                        break; // Found the first stick to the right
                    }
                }
            } else {
                // 3. FLY LEFT: Check indices i < bird
                // The bird is positioned at 'bird', so we search from bird-1 down to 0.
                for (int i = bird - 1; i >= 0; i--) {
                    if (forest[i] > 0) {
                        foundIndex = i;
                        break; // Found the first stick to the left
                    }
                }
            }

            // A stick is guaranteed to be found according to problem constraints.
            if (foundIndex != -1) {
                // 2. and 4. Collect the stick, update state, and remove from forest.

                int stickLength = forest[foundIndex];

                totalLength += stickLength;
                foundStickIndices.add(foundIndex);

                // Remove the stick from the forest by setting its value to 0.
                forest[foundIndex] = 0;

                // Change direction for the next flight.
                flyRight = !flyRight;

            } else {
                // Fallback for safety, though guaranteed not to happen.
                System.err.println("Critical Error: No stick found. Breaking loop.");
                break;
            }
        }

        return foundStickIndices;
    }

    // Main method for testing the example case.
    public static void main(String[] args) {
        // Example: forest = [25, 0, 50, 0, 0, 0, 0, 15, 0, 0, 25], bird = 4
        // Goal: totalLength >= 100

        // Create a copy of the array for the simulation, as the array is modified in-place.
        int[] exampleForest = {25, 0, 50, 0, 0, 0, 0, 15, 0, 0, 25};
        int exampleBird = 4;

        TheBirdsNest solver = new TheBirdsNest();
        List<Integer> result = solver.solution(exampleForest, exampleBird);

        System.out.println("Initial Forest: " + Arrays.toString(new int[]{25, 0, 50, 0, 0, 0, 0, 15, 0, 0, 25}));
        System.out.println("Initial Bird Position: " + exampleBird);

        /* * Expected stick collection sequence (Total Length 100):
         * 1. Fly Right: Index 7 (Length 15). Total = 15. Direction becomes Left.
         * 2. Fly Left: Index 2 (Length 50). Total = 65. Direction becomes Right.
         * 3. Fly Right: Index 10 (Length 25). Total = 90. Direction becomes Left.
         * 4. Fly Left: Index 0 (Length 25). Total = 115. Stop (>= 100).
         * * Expected Output: [7, 2, 10, 0]
         */

        System.out.println("Found Stick Indices (Order Found): " + result);
    }
}
