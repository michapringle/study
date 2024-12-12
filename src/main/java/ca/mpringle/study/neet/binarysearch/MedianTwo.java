package ca.mpringle.study.neet.binarysearch;

import java.util.ArrayList;
import java.util.List;

final class MedianTwo {

    private MedianTwo() {
    }

    /**
     * You are given two integer arrays nums1 and nums2 of size m and n respectively,
     * where each is sorted in ascending order. Return the median value among all
     * elements of the two arrays.
     * <p>
     * Your solution must run in O(log(m+n)) time.
     * <p>
     * 2:30 -> 4:40 -- even though I decided the fast solution was crap, it still took me a while.
     */
    static double findMedianSortedArrays(final int[] nums1, final int[] nums2) {

        // the solution to this is disgusting, basically involves keeping track of the
        // left and right indexes when going through both lists. Just because you can
        // do something doesn't mean you should.

        // simpler solution below O(m + n) time
        int i = 0;
        int j = 0;
        final int size = (nums1.length + nums2.length) / 2 + 1;
        final List<Integer> values = new ArrayList<>(size);

        while (i + j < size) {

            if (j == nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
                values.add(nums1[i]);
                i++;
            } else {
                values.add(nums2[j]);
                j++;
            }
        }

        final int s = values.size();

        return (nums1.length + nums2.length) % 2 == 1
                ? values.get(s - 1)
                : (values.get(s - 2) + values.get(s - 1)) / 2D;
    }
}
