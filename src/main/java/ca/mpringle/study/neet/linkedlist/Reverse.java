package ca.mpringle.study.neet.linkedlist;

final class Reverse {


    /**
     * Given the beginning of a singly linked list head, reverse the list,
     * and return the new beginning of the list.
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     * <p>
     * 3:40 -> 4:25 - disgusting api from neetcode, plus their ListNode is not properly
     * defined above, int val is private, but next is not. what a PoS
     */
    public static ListNode reverseList(final ListNode head) {

        ListNode h = head;
        ListNode reversed = null;

        while (h.next != null) {
            reversed = new ListNode(h.value, reversed);
            h = h.next;
        }

        reversed = new ListNode(h.value, reversed);

        return reversed;
    }

    public static class ListNode {

        int value;
        ListNode next;

        ListNode() {
        }

        ListNode(int value) {
            this.value = value;
        }

        ListNode(int value, ListNode next) {

            this.value = value;
            this.next = next;
        }
    }
}
