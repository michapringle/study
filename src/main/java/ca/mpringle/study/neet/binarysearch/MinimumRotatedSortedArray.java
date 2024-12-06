package ca.mpringle.study.neet.binarysearch;

final class MinimumRotatedSortedArray {

    private MinimumRotatedSortedArray() {
    }

    /**
     * You are given an array of length n which was originally sorted in ascending order.
     * It has now been rotated between 1 and n times. For example,
     * the array nums = [1,2,3,4,5,6] might become:
     * <p>
     * [3,4,5,6,1,2] if it was rotated 4 times.
     * [1,2,3,4,5,6] if it was rotated 6 times.
     * <p>
     * Notice that rotating the array 4 times moves the last four elements of the array
     * to the beginning. Rotating the array 6 times produces the original array.
     * <p>
     * Assuming all elements in the rotated sorted array nums are unique, return the
     * minimum element of this array.
     * <p>
     * A solution that runs in O(n) time is trivial, can you write an algorithm
     * that runs in O(log n) time?
     * <p>
     * 4:30 -> 4:52
     */
    static int findMin(final int[] nums) {

        int min = 0;
        int max = nums.length;
        int previousNum = nums[min];

        while (min != max) {
            int index = (min + max) / 2;
            if (previousNum < nums[index]) {
                min = index;
            } else {
                max = index;
            }
            previousNum = nums[index];
        }

        return min == nums.length - 1 ? nums[0] : nums[min + 1];
    }
}
