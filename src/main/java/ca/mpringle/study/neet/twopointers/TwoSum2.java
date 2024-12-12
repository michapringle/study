package ca.mpringle.study.neet.twopointers;


final class TwoSum2 {

    private TwoSum2() {
    }

    /**
     * Given an array of integers numbers that is sorted in non-decreasing order.
     * <p>
     * Return the indices (1-indexed) of two numbers, [index1, index2], such that they
     * add up to a given target number target and index1 < index2. Note that index1
     * and index2 cannot be equal, therefore you may not use the same element twice.
     * <p>
     * There will always be exactly one valid solution.
     * <p>
     * Your solution must use O(1)O(1) additional space.
     */
    // 12:05 -> 12:25
    static int[] twoSum(final int[] numbers, final int target) {

        if (numbers == null) {
            return new int[]{};
        }

        for (int i = 0, j = numbers.length - 1; i < j; ) {

            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            }

            if (numbers[i] + numbers[j] >= target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{};
    }

}
