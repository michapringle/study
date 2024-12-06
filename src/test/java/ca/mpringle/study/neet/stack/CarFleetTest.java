package ca.mpringle.study.neet.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class CarFleetTest {

    @ParameterizedTest
    @MethodSource("carFleetData")
    void carFleetTest(final int target, final int[] positions, final int[] speeds, final int expected) {

        final int actual = CarFleet.carFleet(target, positions, speeds);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> carFleetData() {

        return Stream.of(
                Arguments.of(
                        10,
                        new int[]{1, 4},
                        new int[]{3, 2},
                        1
                ),
                Arguments.of(
                        10,
                        new int[]{4, 1, 0, 7},
                        new int[]{2, 2, 1, 1},
                        3
                ),
                Arguments.of(
                        10,
                        new int[]{0, 4, 2},
                        new int[]{2, 1, 3},
                        1
                ),
                Arguments.of(
                        12,
                        new int[]{10, 8, 0, 5, 3},
                        new int[]{2, 4, 1, 1, 3},
                        3
                )
        );
    }
}
