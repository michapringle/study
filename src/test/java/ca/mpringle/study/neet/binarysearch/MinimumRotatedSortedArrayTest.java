package ca.mpringle.study.neet.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class MinimumRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("findMinData")
    void searchTest(final int[] numbers, final int expected) {

        final int actual = MinimumRotatedSortedArray.findMin(numbers);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> findMinData() {

        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 6, 1, 2}, 1),
                Arguments.of(new int[]{4, 5, 0, 1, 2, 3}, 0),
                Arguments.of(new int[]{4, 5, 6, 7}, 4),
                Arguments.of(new int[]{5, 6, 7, 4}, 4),
                Arguments.of(new int[]{6, 7, 4, 5}, 4),
                Arguments.of(new int[]{7, 4, 5, 6}, 4)
        );
    }
}
