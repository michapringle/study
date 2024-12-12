package ca.mpringle.study.neet.twopointers;

final class MaxWater {

    private MaxWater() {
    }

    /**
     * You are given an integer array heights where heights[i] represents the height of the
     * ith bar.
     * <p>
     * You may choose any two bars to form a container. Return the maximum amount of water a
     * container can store.
     */
    // 3:57 -> 4:10
    static int maxArea(final int[] heights) {

        if (heights == null || heights.length < 2) {
            return 0;
        }

        int maxHeight = 0;
        for (int i = 0, j = heights.length - 1; i < j; ) {

            int height = Math.min(heights[i], heights[j]) * (j - i);
            maxHeight = Math.max(height, maxHeight);

            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxHeight;
    }
}
