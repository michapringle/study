package ca.mpringle.study.neet.binarysearch;

final class BinarySearch {

    private BinarySearch() {
    }

    /**
     * You are given an array of distinct integers nums, sorted in ascending order,
     * and an integer target.
     * <p>
     * Implement a function to search for target within nums. If it exists,
     * then return its index, otherwise, return -1.
     * <p>
     * Your solution must run in O(logn) time.
     * <p>
     * 2:45 -> 3:40 -- wtf, seriously took me this long?
     */
    static int search(final int[] nums, final int target) {

        final Index index = new Index(0, nums.length);

        while (target != nums[index.index()] && index.isValid()) {

            if (target > nums[index.index()]) {
                index.newMin();
            } else {
                index.newMax();
            }
        }

        return target == nums[index.index()] ? index.index() : -1;
    }

    private static class Index {

        private int min;
        private int max;

        public Index(final int min, final int max) {
            this.min = min;
            this.max = max;
        }

        int index() {
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
