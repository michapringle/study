package ca.mpringle.study.neet.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class PermuationTest {

    @ParameterizedTest
    @MethodSource("checkInclusionData")
    void characterReplacementTest(final String substring, final String string, final boolean expected) {

        final boolean actual = Permutation.checkInclusion(substring, string);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> checkInclusionData() {

        return Stream.of(
                Arguments.of(
                        null,
                        null,
                        true
                ),
                Arguments.of(
                        "",
                        "",
                        true
                ),
                Arguments.of(
                        "a",
                        "a",
                        true
                ),
                Arguments.of(
                        "a",
                        "ab",
                        true
                ),
                Arguments.of(
                        "abc",
                        "lecabee",
                        true
                ),
                Arguments.of(
                        "adc",
                        "dcda",
                        true
                ),
                Arguments.of(
                        "abc",
                        "lecaabee",
                        false
                )
        );
    }
}
