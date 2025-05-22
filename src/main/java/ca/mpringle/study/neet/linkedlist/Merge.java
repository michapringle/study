package ca.mpringle.study.neet.linkedlist;

final class Merge {


    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     * <p>
     * Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
     * <p>
     * The new list should be made up of nodes from list1 and list2.
     * <p>
     * 12:50 -> 1:10 - rewrote due to disgusting api from neetcode
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // start with a dummy node that can be discarded later
        ListNode head = new ListNode();
        ListNode index = head;

        while (list1 != null || list2 != null) {

            final boolean isFirstListSmallestValue = list1 != null && list2 != null && list1.val < list2.val;
            if (isFirstListSmallestValue || list2 == null) {
                index.next = list1;
                index = list1;
                list1 = list1.next;

            } else {
                index.next = list2;
                index = list2;
                list2 = list2.next;
            }
        }

        return head.next;
    }
}
