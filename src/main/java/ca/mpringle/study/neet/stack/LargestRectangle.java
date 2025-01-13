package ca.mpringle.study.neet.stack;

final class LargestRectangle {

    private LargestRectangle() {
    }

    /**
     * You are given an array of integers heights where heights[i] represents the
     * height of a bar. The width of each bar is 1.
     * <p>
     * Return the area of the largest rectangle that can be formed among the bars.
     * <p>
     * Note: This chart is known as a histogram.
     * <p>
     * 1:30 -> 2:45 -- looked up solution
     */
    static int largestRectangleArea(final int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];

            int rightMost = i + 1;
            while (rightMost < n && heights[rightMost] >= height) {
                rightMost++;
            }

            int leftMost = i;
            while (leftMost >= 0 && heights[leftMost] >= height) {
                leftMost--;
            }

            rightMost--;
            leftMost++;
            maxArea = Math.max(maxArea, height * (rightMost - leftMost + 1));
        }
        return maxArea;
    }
}
