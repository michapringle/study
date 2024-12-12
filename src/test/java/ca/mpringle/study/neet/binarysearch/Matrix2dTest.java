package ca.mpringle.study.neet.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class Matrix2dTest {

    @ParameterizedTest
    @MethodSource("searchMatrixData")
    void searchTest(final int[][] matrix, final int target, final boolean expected) {

        final boolean actual = Matrix2d.searchMatrix(matrix, target);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> searchMatrixData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{},
                        2,
                        false
                ),
                Arguments.of(
                        new int[][]{{}},
                        2,
                        false
                ),
                Arguments.of(
                        new int[][]{{}, {}},
                        2,
                        false
                ),
                Arguments.of(
                        new int[][]{{1}, {2}, {3}},
                        2,
                        true
                ),
                Arguments.of(
                        new int[][]{{1, 2, 3}},
                        2,
                        true
                ),
                Arguments.of(
                        new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}},
                        10,
                        true
                ),
                Arguments.of(
                        new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}},
                        15,
                        false
                )
        );
    }
}
