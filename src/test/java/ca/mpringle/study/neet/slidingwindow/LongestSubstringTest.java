package ca.mpringle.study.neet.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class LongestSubstringTest {

    @ParameterizedTest
    @MethodSource("lengthOfLongestSubstringData")
    void lengthOfLongestSubstringTest(final String string, final int expected) {

        final int actual = LongestSubstring.lengthOfLongestSubstring(string);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> lengthOfLongestSubstringData() {

        return Stream.of(
                Arguments.of(
                        null,
                        0
                ),
                Arguments.of(
                        "",
                        0
                ),
                // "6789012345" is the longest string without duplicate characters
                Arguments.of(
                        "1234566789012345",
                        10
                ),

                // "xyz" is the longest string without duplicate characters
                Arguments.of(
                        "zxyzxyz",
                        3
                ),
                Arguments.of(
                        "1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p7q8r9s0t1u2v3w4x5y6z7A8B9C0D1E2F3G4H5I6J7K8L9M0N1O2P3Q4R5S6T7U8V9W0X1Y2Z3",
                        21
                )
        );
    }
}
