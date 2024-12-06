package ca.mpringle.study.neet.binarysearch;

final class SortedRotatedSortedArray {

    private SortedRotatedSortedArray() {
    }

    /**
     * You are given an array of length n which was originally sorted in ascending order.
     * It has now been rotated between 1 and n times. For example,
     * the array nums = [1,2,3,4,5,6] might become:
     * <p>
     * [3,4,5,6,1,2] if it was rotated 4 times.
     * [1,2,3,4,5,6] if it was rotated 6 times.
     * <p>
     * Given the rotated sorted array nums and an integer target, return the index of target
     * within nums, or -1 if it is not present.
     * <p>
     * You may assume all elements in the sorted rotated array nums are unique,
     * <p>
     * A solution that runs in O(n) time is trivial, can you write an algorithm that
     * runs in O(log n) time?
     * <p>
     * 2:50 -> 3:58 -- took a dump, and had to fix the index not converging properly
     */
    static int search(final int[] nums, final int target) {

        int offset = findMinIndex(nums);
        return offsetSearch(nums, offset, target);
    }

    private static int findMinIndex(final int[] nums) {

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

        return min == nums.length - 1 ? 0 : min + 1;
    }

    private static int offsetSearch(final int[] nums, final int offset, final int target) {

        final Index index = new Index(0, nums.length, offset);

        while (target != nums[index.offsetIndex()] && index.isValid()) {

            if (target > nums[index.offsetIndex()]) {
                index.newMin();
            } else {
                index.newMax();
            }
        }

        return target == nums[index.offsetIndex()] ? index.offsetIndex() : -1;
    }

    private static class Index {

        private int min;
        private int max;
        private final int offset;
        private final int originalMax;

        public Index(final int min, final int max, final int offset) {
            this.min = min;
            this.max = max;
            this.offset = offset;
            this.originalMax = max;
        }

        int offsetIndex() {
            return (index() + offset) % originalMax;
        }

        private int index() {
            return (min + max) / 2;
        }

        void newMin() {
            min = Math.max(index(), min + 1);
        }

        void newMax() {
            max = Math.min(index(), max - 1);
        }

        boolean isValid() {
            return min < max;
        }
    }
}
