package ca.mpringle.study.neet.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class TrappingWaterTest {

    @ParameterizedTest
    @MethodSource("trapData")
    void maxAreaTest(final int[] input, final int expected) {

        final int actual = TrappingWater.trap(input);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> trapData() {

        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{0, 1}, 0),
                Arguments.of(new int[]{1, 0, 1}, 1),
                Arguments.of(new int[]{2, 2, 2}, 0),
                Arguments.of(new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1}, 9),
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6)
        );
    }
}
