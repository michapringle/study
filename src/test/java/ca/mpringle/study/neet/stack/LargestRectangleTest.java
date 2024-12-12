package ca.mpringle.study.neet.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class LargestRectangleTest {

    @ParameterizedTest
    @MethodSource("largestRectangleAreaData")
    void largestRectangleAreaTest(final int[] heights, final int expected) {

        final int actual = LargestRectangle.largestRectangleArea(heights);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> largestRectangleAreaData() {

        return Stream.of(
                // *   *
                // *   *
                // * * *
                Arguments.of(
                        new int[]{3, 1, 3},
                        3
                ),
                // * *
                // * *
                // * * *
                Arguments.of(
                        new int[]{3, 3, 1},
                        6
                ),
                // * *
                // * *
                // * *
                Arguments.of(
                        new int[]{3, 3},
                        6
                ),
                Arguments.of(
                        //     *
                        //     *
                        //     *
                        //     *
                        //   * *
                        //   * *
                        // * * *
                        new int[]{1, 3, 7},
                        7
                ),
                // *
                // * * *
                // * * *
                Arguments.of(
                        new int[]{3, 2, 2},
                        6
                ),

                //   *     *
                //   * * * *
                // * * * * *
                Arguments.of(
                        new int[]{1, 3, 2, 2, 3},
                        8
                ),
                // *   *
                // *   *
                // *   *
                // *   *     *
                // *   *     *
                // *   * * * *
                // * * * * * *
                Arguments.of(
                        new int[]{7, 1, 7, 2, 2, 4},
                        8
                )
        );
    }
}
