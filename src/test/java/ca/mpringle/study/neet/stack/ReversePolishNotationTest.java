package ca.mpringle.study.neet.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class ReversePolishNotationTest {

    @ParameterizedTest
    @MethodSource("evalRPNData")
    void isValidTest(final String[] tokens, final int expected) {

        final int actual = ReversePolishNotation.evalRPN(tokens);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> evalRPNData() {


        return Stream.of(
                Arguments.of(new String[]{}, 0),
                // 1 + 2 = 3
                Arguments.of(new String[]{"1", "2", "+"}, 3),
                // (1 + 2) * 3) = 6
                Arguments.of(new String[]{"1", "2", "+", "3", "*"}, 9),
                // ((1 + 2) * 3) - 4 = 5
                Arguments.of(new String[]{"1", "2", "+", "3", "*", "4", "-"}, 5),
                // (13 / 5) + 4 = 6
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)

        );
    }
}
