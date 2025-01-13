package ca.mpringle.study.neet.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class ValidParenthesesTest {

    @ParameterizedTest
    @MethodSource("isValidData")
    void isValidTest(final String sequence, final boolean expected) {

        final boolean actual = ValidParentheses.isValid(sequence);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> isValidData() {

        return Stream.of(
                Arguments.of("", true),
                Arguments.of("([{}])", true),
                Arguments.of("[(])", false),
                Arguments.of("]", false),
                Arguments.of("]]", false),
                Arguments.of("[]]", false)
        );
    }
}
