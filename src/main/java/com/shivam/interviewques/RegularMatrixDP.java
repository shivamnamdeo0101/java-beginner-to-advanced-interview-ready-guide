package com.shivam.interviewques;

public class RegularMatrixDP {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {2, 3, 1, 1},
                {1, 1, 1, 0},
                {1, 4, 1, 1}
        };

        int rowsCount = countRows(matrix);
        int colsCount = countCols(matrix);
        int diagCount = countDiagonals(matrix);

        int totalCount = rowsCount + colsCount + diagCount;

        System.out.println("Rows with all elements same: " + rowsCount);
        System.out.println("Columns with all elements same: " + colsCount);
        System.out.println("Diagonals with all elements same: " + diagCount);
        System.out.println("Total count: " + totalCount);
    }

    // Count rows with all elements same
    static int countRows(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            boolean same = true;
            for (int j = 1; j < mat[i].length; j++) {
                if (mat[i][j] != mat[i][0]) {
                    same = false;
                    break;
                }
            }
            if (same) count++;
        }
        return count;
    }

    // Count columns with all elements same
    static int countCols(int[][] mat) {
        int n = mat.length;
        int count = 0;
        for (int j = 0; j < n; j++) {
            boolean same = true;
            for (int i = 1; i < n; i++) {
                if (mat[i][j] != mat[0][j]) {
                    same = false;
                    break;
                }
            }
            if (same) count++;
        }
        return count;
    }

    // Count diagonals with all elements same (count each diagonal only once)
    static int countDiagonals(int[][] mat) {
        int n = mat.length;
        int diagCount = 0;

        // Primary diagonal
        boolean primarySame = true;
        for (int i = 1; i < n; i++) {
            if (mat[i][i] != mat[0][0]) {
                primarySame = false;
                break;
            }
        }
        if (primarySame) diagCount++;

        // Secondary diagonal
        boolean secondarySame = true;
        for (int i = 1; i < n; i++) {
            if (mat[i][n - 1 - i] != mat[0][n - 1]) {
                secondarySame = false;
                break;
            }
        }
        if (secondarySame) diagCount++;

        return diagCount;
    }
}
