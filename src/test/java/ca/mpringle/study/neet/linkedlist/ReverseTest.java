package ca.mpringle.study.neet.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

final class ReverseTest {

    @ParameterizedTest
    @MethodSource("reverseListData")
    void carFleetTest(final Reverse.ListNode input, Reverse.ListNode expected) {

        Reverse.ListNode actual = Reverse.reverseList(input);

        while (actual.next != null && expected.next != null) {
            assertEquals(expected.value, actual.value);
            actual = actual.next;
            expected = expected.next;
        }

        assertNull(actual.next);
        assertNull(expected.next);
    }

    static Stream<Arguments> reverseListData() {


        return Stream.of(
                Arguments.of(
                        new Reverse.ListNode(0, new Reverse.ListNode(1, new Reverse.ListNode(2, new Reverse.ListNode(3)))),
                        new Reverse.ListNode(3, new Reverse.ListNode(2, new Reverse.ListNode(1, new Reverse.ListNode(0))))
                ),
                Arguments.of(
                        new Reverse.ListNode(),
                        new Reverse.ListNode()
                )
        );
    }
}
