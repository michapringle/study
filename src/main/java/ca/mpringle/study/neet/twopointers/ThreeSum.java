package ca.mpringle.study.neet.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

final class ThreeSum {

    private ThreeSum() {
    }

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
     * <p>
     * The output should not contain any duplicate triplets. You may return the output
     * and the triplets in any order.
     */
    // 3:30 -> 4:00
    static List<List<Integer>> threeSum(final int[] nums) {

        return threeSumNov10(nums);
    }

    static List<List<Integer>> threeSumOriginal(final int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        final Set<List<Integer>> results = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] == -nums[k]) {
                        results.add(newSortedList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(results);
    }

    static List<List<Integer>> threeSumNov10(final int[] nums) {

        final Set<List<Integer>> result = new HashSet<>();

        if (nums == null) {
            return new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(newSortedList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }


    private static <T extends Comparable<T>> List<T> newSortedList(final T... ts) {
        return Arrays.stream(ts).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}
