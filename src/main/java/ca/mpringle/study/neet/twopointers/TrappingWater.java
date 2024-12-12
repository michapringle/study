package ca.mpringle.study.neet.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class TrappingWater {

    private TrappingWater() {
    }

    /**
     * You are given an array non-negative integers heights which represent an elevation map.
     * Each value heights[i] represents the height of a bar, which has a width of 1.
     * <p>
     * Return the maximum area of water that can be trapped between the bars.
     */
    // note took me about an hour to realize I could count the gaps between bars horizontally
    // also, I ate dinner which probably added 20 minutes to time.
    // 4:51 -> 6:41
    static int trap(final int[] heights) {

        if (heights == null || heights.length < 3) {
            return 0;
        }

        final int maxHeight = Arrays.stream(heights).max().getAsInt();
        int total = 0;

        for (int height = maxHeight; height > 0; height--) {

            final List<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] >= height) {
                    indexes.add(i);
                }
            }

            for (int i = 0; i < indexes.size() - 1; i++) {
                total += indexes.get(i + 1) - indexes.get(i) - 1;
            }
        }

        return total;
    }
}
