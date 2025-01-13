package ca.mpringle.study.neet.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

final class DailyTemperaturesTest {

    @ParameterizedTest
    @MethodSource("dailyTemperaturesData")
    void dailyTemperaturesDataTest(final int[] temperatures, final int[] expected) {

        final int[] actual = DailyTemperatures.dailyTemperatures(temperatures);

        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> dailyTemperaturesData() {

        return Stream.of(
                Arguments.of(
                        new int[]{30, 31, 32, 33},
                        new int[]{1, 1, 1, 0}
                ),
                Arguments.of(
                        new int[]{30, 30, 30, 30},
                        new int[]{0, 0, 0, 0}
                ),
                Arguments.of(
                        new int[]{30, 38, 30, 36, 35, 40, 28},
                        new int[]{1, 4, 1, 2, 1, 0, 0}
                ),
                Arguments.of(

                        new int[]{22, 21, 20},
                        new int[]{0, 0, 0}
                )
        );
    }
}
