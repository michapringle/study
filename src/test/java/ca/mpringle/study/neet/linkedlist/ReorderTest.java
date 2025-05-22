package ca.mpringle.study.neet.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

final class ReorderTest {

    @ParameterizedTest
    @MethodSource("reorderListData")
    void reorderListTest(ListNode actual, ListNode expected) {

        Reorder.reorderList(actual);

        while (actual != null && expected != null) {
            assertEquals(expected.val, actual.val);
            actual = actual.next;
            expected = expected.next;
        }

        assertNull(actual);
        assertNull(expected);
    }

    static Stream<Arguments> reorderListData() {

        return Stream.of(
//                Arguments.of(
//                        null,
//                        null
//                ),
//
//                Arguments.of(
//                        new ListNode(),
//                        new ListNode()
//                ),
//                Arguments.of(
//                        new ListNode(1),
//                        new ListNode(1)
//                ),
                Arguments.of(
                        new ListNode(0,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(3,
                                                        new ListNode(4,
                                                                new ListNode(5,
                                                                        new ListNode(6)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        ),
                        new ListNode(0,
                                new ListNode(6,
                                        new ListNode(1,
                                                new ListNode(5,
                                                        new ListNode(2,
                                                                new ListNode(4,
                                                                        new ListNode(3)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }
}
