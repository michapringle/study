package ca.mpringle.study.neet.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

final class ListNodeTest {

    @ParameterizedTest
    @MethodSource("fromLinkedListData")
    void fromLinkedListTest(final LinkedList<Integer> input, ListNode expected) {

        ListNode actual = ListNode.fromLinkedList(input);

        while (actual != null && expected != null) {
            assertEquals(expected.val, actual.val);
            actual = actual.next;
            expected = expected.next;
        }

        assertNull(actual);
        assertNull(expected);
    }

    @ParameterizedTest
    @MethodSource("toLinkedListData")
    void toLinkedListTest(final ListNode input, List<Integer> expected) {

        LinkedList<Integer> actual = ListNode.toLinkedList(input);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> fromLinkedListData() {

        return Stream.of(
                Arguments.of(
                        newLinkedList(),
                        null
                ),
                Arguments.of(
                        newLinkedList(1),
                        new ListNode(1)
                ),
                Arguments.of(
                        newLinkedList(1, 2, 3, 4, 5),
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5)
                                                )
                                        )
                                )
                        )
                )
        );
    }

    static Stream<Arguments> toLinkedListData() {

        return Stream.of(
                Arguments.of(
                        null,
                        newLinkedList()
                ),
                Arguments.of(
                        new ListNode(1),
                        newLinkedList(1)
                ),
                Arguments.of(
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5)
                                                )
                                        )
                                )
                        ),
                        newLinkedList(1, 2, 3, 4, 5)
                )
        );
    }

    static LinkedList<Integer> newLinkedList(Integer... values) {

        return new LinkedList<>(Arrays.asList(values));
    }
}
