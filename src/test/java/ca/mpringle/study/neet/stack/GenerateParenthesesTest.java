package ca.mpringle.study.neet.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class GenerateParenthesesTest {

    @ParameterizedTest
    @MethodSource("generateParenthesisData")
    void generateParenthesisTest(final int numberOfPermutations, final List<String> expected) {

        final List<String> actual = GenerateParentheses.generateParenthesis(numberOfPermutations);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> generateParenthesisData() {

        return Stream.of(
                Arguments.of(
                        1,
                        List.of("()")
                ),
                Arguments.of(
                        2,
                        List.of("(())", "()()")
                ),
                Arguments.of(
                        3,
                        List.of("((()))", "(()())", "(())()", "()(())", "()()()")
                )
        );
    }
}
