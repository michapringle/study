package ca.mpringle.study.neet.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class MaxWaterTest {

    @ParameterizedTest
    @MethodSource("maxAreaData")
    void maxAreaTest(final int[] input, final int expected) {

        final int actual = MaxWater.maxArea(input);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> maxAreaData() {

        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{0, 1}, 0),
                Arguments.of(new int[]{1, 7, 2, 5, 4, 7, 3, 6}, 36),
                Arguments.of(new int[]{2, 2, 2}, 4)
        );
    }
}
