package ca.mpringle.study.neet.binarysearch;

final class Matrix2d {

    private Matrix2d() {
    }

    /**
     * You are given an m x n 2-D integer array matrix and an integer target.
     * <p>
     * Each row in matrix is sorted in non-decreasing order.
     * The first integer of every row is greater than the last integer of the previous row.
     * <p>
     * Return true if target exists within matrix or false otherwise.
     * <p>
     * Can you write a solution that runs in O(log(m * n)) time?
     * <p>
     * 2:35 -> 3:20 - not bad after figuring out the first binary search
     */
    static boolean searchMatrix(final int[][] matrix, final int target) {

        if (matrix.length == 0) {
            return false;
        }

        if (matrix[0].length == 0) {
            return false;
        }

        int min = 0;
        int max = matrix.length * matrix[0].length;
        int maxAttempts = (int) (Math.log(max) / Math.log(2)) + 1;
        int index = (min + max) / 2;
        int attempts = 0;
        int[] index2d = {};

        do {
            // compute the 2d index as [row][col]
            index2d = new int[]{index / matrix[0].length, index % matrix[0].length};

            if (target > matrix[index2d[0]][index2d[1]]) {
                min = index;
            } else {
                max = index;
            }
            index = (min + max) / 2;

            attempts++;
        } while (target != matrix[index2d[0]][index2d[1]] && attempts <= maxAttempts);


        return target == matrix[index2d[0]][index2d[1]];
    }
}
