package ca.mpringle.study.neet.linkedlist;

import java.util.HashSet;
import java.util.Set;

final class Cycle {


    /**
     * Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return false.
     * <p>
     * There is a cycle in a linked list if at least one node in the list can be visited again by following the next pointer.
     * <p>
     * Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.
     * <p>
     * Note: index is not given to you as a parameter.
     * 3:10 -> 3:30
     */
    public static boolean hasCycle(final ListNode head) {

        if (head == null) {
            return false;
        }

        final Set<Integer> instanceHashes = new HashSet<>();
        ListNode iterator = head;

        while (iterator.next != null) {

            if (instanceHashes.contains(iterator.hashCode())) {
                return true;
            } else {
                instanceHashes.add(iterator.hashCode());
                iterator = iterator.next;
            }
        }

        return false;
    }
}
