package ca.mpringle.study.neet.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class CycleTest {

    @ParameterizedTest
    @MethodSource("hasCycleData")
    void hasCycleTest(final ListNode input, final boolean expected) {

        final boolean actual = Cycle.hasCycle(input);

        assertEquals(expected, actual);
    }

    private static ListNode cycle() {

        ListNode a = new ListNode(1);
        a.next =  new ListNode(3, a);
        return a;
    }

    static Stream<Arguments> hasCycleData() {

        return Stream.of(
                Arguments.of(
                        null,
                        false
                ),

                Arguments.of(
                        new ListNode(),
                        false
                ),
                Arguments.of(
                        new ListNode(1, new ListNode(2)),
                        false
                ),
                Arguments.of(
                        cycle(),
                        true

                )
        );
    }
}
