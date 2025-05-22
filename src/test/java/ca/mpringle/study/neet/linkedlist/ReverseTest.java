package ca.mpringle.study.neet.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

final class ReverseTest {

    @ParameterizedTest
    @MethodSource("reverseListData")
    void carFleetTest(final ListNode input, ListNode expected) {

        ListNode actual = Reverse.reverseList(input);

        while (actual != null && expected != null) {
            assertEquals(expected.val, actual.val);
            actual = actual.next;
            expected = expected.next;
        }

        assertNull(actual);
        assertNull(expected);
    }

    static Stream<Arguments> reverseListData() {


        return Stream.of(
                Arguments.of(
                        null,
                        null
                ),
                Arguments.of(
                        new ListNode(),
                        new ListNode()
                ),
                Arguments.of(
                        new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3)))),
                        new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(0))))
                )
        );
    }
}
