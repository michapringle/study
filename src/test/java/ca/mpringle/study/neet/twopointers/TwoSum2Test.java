package ca.mpringle.study.neet.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

final class TwoSum2Test {

    @ParameterizedTest
    @MethodSource("isTwoSumData")
    void twoSumTest(final int[] input, final int index, final int[] expected) {

        final int[] actual = TwoSum2.twoSum(input, index);

        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> isTwoSumData() {

        return Stream.of(
                Arguments.of(null, 0, new int[]{}),
                Arguments.of(new int[]{}, 0, new int[]{}),
                Arguments.of(new int[]{1, 2, 3, 4}, 3, new int[]{1, 2}),
                Arguments.of(new int[]{1, 3, 5, 7, 8}, 10, new int[]{2, 4})
        );
    }
}
