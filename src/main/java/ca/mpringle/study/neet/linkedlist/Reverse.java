package ca.mpringle.study.neet.linkedlist;

final class Reverse {


    /**
     * Given the beginning of a singly linked list head, reverse the list,
     * and return the new beginning of the list.
     * <p>
     * 11:45 -> 12:15 - rewrote several times due to disgusting api from neetcode
     */
    public static ListNode reverseList(ListNode head) {

        ListNode reverse = null;
        ListNode index;

        while(head != null) {
            index = head;
            head = head.next;
            index.next = reverse;
            reverse = index;
        }

        return reverse;
    }
}
