package ca.mpringle.study.neet.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class LongestRepeatingTest {

    @ParameterizedTest
    @MethodSource("characterReplacementData")
    void characterReplacementTest(final String string, final int k, final int expected) {

        final int actual = LongestRepeating.characterReplacement(string, k);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> characterReplacementData() {

        return Stream.of(
                Arguments.of(
                        null,
                        0,
                        0
                ),
                Arguments.of(
                        "",
                        0,
                        0
                ),
                Arguments.of(
                        "X",
                        1,
                        1
                ),
                Arguments.of(
                        "XY",
                        1,
                        2
                ),
                Arguments.of(
                        "CAACA",
                        2,
                        5
                ),
                Arguments.of(
                        "BAAAB",
                        2,
                        5
                ),
                Arguments.of(
                        "ABCA",
                        2,
                        4
                ),
                Arguments.of(
                        "BAAA",
                        0,
                        3
                ),
                Arguments.of(
                        "AAAB",
                        0,
                        3
                ),
                // replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
                Arguments.of(
                        "XYYX",
                        2,
                        4
                ),
                Arguments.of(
                        "AAABABB",
                        1,
                        5
                ),
                Arguments.of(
                        "AABABBA",
                        1,
                        4
                )
        );
    }
}
