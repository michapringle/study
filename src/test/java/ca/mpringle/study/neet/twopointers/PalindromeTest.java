package ca.mpringle.study.neet.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class PalindromeTest {

    @ParameterizedTest
    @MethodSource("isPalindromeData")
    void isPalindromeTest(final String input, final boolean expected) {

        final boolean actual = Palindrome.isPalindrome(input);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> isPalindromeData() {

        return Stream.of(
                Arguments.of(null, false),
                Arguments.of("", true),
                Arguments.of("Was it a car or a cat I saw?", true),
                Arguments.of("tab a cat", false),
                Arguments.of("0P", false)
        );
    }
}
