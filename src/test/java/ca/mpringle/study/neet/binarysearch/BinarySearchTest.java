package ca.mpringle.study.neet.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class BinarySearchTest {

    @ParameterizedTest
    @MethodSource("binarySearchData")
    void searchTest(final int[] nums, final int target, final int expected) {

        final int actual = BinarySearch.search(nums, target);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> binarySearchData() {

        return Stream.of(
                Arguments.of(new int[]{1, 3}, 3, 1),
                Arguments.of(new int[]{-1, 0, 2, 4, 6, 8}, 3, -1),
                Arguments.of(new int[]{-1, 0, 2, 4, 6, 8}, 4, 3),
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                Arguments.of(new int[]{2, 5}, 2, 0),
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 3, 2)
        );
    }
}
