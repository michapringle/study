package ca.mpringle.study.neet.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class MedianTwoTest {

    @ParameterizedTest
    @MethodSource("findMedianSortedArraysData")
    void searchTest(final int[] nums1, final int[] nums2, final double expected) {

        final double actual = MedianTwo.findMedianSortedArrays(nums1, nums2);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> findMedianSortedArraysData() {

        return Stream.of(
                Arguments.of(new int[]{}, new int[]{1}, 1),
                Arguments.of(new int[]{1, 2}, new int[]{3}, 2.0),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5),
                Arguments.of(new int[]{1, 3}, new int[]{2, 4}, 2.5),
                Arguments.of(new int[]{1, 2, 3, 12, 13}, new int[]{1, 2}, 2.0),
                Arguments.of(new int[]{1, 2, 3, 12, 13}, new int[]{1, 2, 24}, 2.5)
        );
    }
}
