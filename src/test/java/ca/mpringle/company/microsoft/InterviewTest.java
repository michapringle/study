package ca.mpringle.company.microsoft;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class InterviewTest {

    @ParameterizedTest
    @MethodSource("isMethodData")
    void isAnagramTest(final String string1, final String string2, final boolean expected) {

        final boolean actual = Interview.method();

        assertEquals(expected, actual);
    }


    static Stream<Arguments> isMethodData() {

        return Stream.of(
                Arguments.of("", "", true)
        );
    }
}
