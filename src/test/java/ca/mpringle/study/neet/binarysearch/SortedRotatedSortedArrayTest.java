package ca.mpringle.study.neet.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class SortedRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("searchData")
    void searchTest(final int[] numbers, final int target, final int expected) {

        final int actual = SortedRotatedSortedArray.search(numbers, target);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> searchData() {

        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 6, 1, 2}, 1, 4),
                Arguments.of(new int[]{3, 5, 6, 0, 1, 2}, 4, -1),
                Arguments.of(new int[]{1, 3}, 3, 1),
                Arguments.of(new int[]{3, 1}, 1, 1),
                Arguments.of(new int[]{3, 1}, 3, 0)
        );
    }
}
