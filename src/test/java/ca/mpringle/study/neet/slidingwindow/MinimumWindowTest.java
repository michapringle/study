package ca.mpringle.study.neet.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class MinimumWindowTest {

    @ParameterizedTest
    @MethodSource("minWindowData")
    void minWindowTest(final String s1, final String s2, final String expected) {

        final String actual = MinimumWindow.minWindow(s1, s2);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> minWindowData() {

        return Stream.of(
                Arguments.of(
                        null,
                        null,
                        ""
                ),
                Arguments.of(
                        null,
                        "",
                        ""
                ),
                Arguments.of(
                        "",
                        null,
                        ""
                ),
                Arguments.of(
                        "",
                        "",
                        ""
                ),
                Arguments.of(
                        "",
                        "t",
                        ""
                ),
                Arguments.of(
                        "a",
                        "b",
                        ""
                ),
                Arguments.of(
                        "x",
                        "xy",
                        ""
                ),
                Arguments.of(
                        "OUZODYXAZV",
                        "XYZ",
                        "YXAZ"
                ),
                Arguments.of(
                        "xyz",
                        "xyz",
                        "xyz"
                ),
                Arguments.of(
                        "ADOBECODEBANC",
                        "ABC",
                        "BANC"
                )
        );
    }
}
