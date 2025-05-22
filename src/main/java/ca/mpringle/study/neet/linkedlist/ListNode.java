package ca.mpringle.study.neet.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 *   * Definition for singly-linked list from neetcode
 *      * public class ListNode {
 *      * int val;
 *      * ListNode next;
 *      * ListNode() {}
 *      * ListNode(int val) { this.val = val; }
 *      * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *      * }
 *      <p/>
 *      Problems with this API
 *      - this class requires an empty list to be represented as null, because { value = 0, next = null } is a 0 node
 *      - you can iterate the list in order, but the list is built in reverse order
 */
public final class ListNode {


    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {

        this.val = val;
        this.next = next;
    }

    // static because ListNode is defined as above in the neetcode library
    // this can be copied into the class as required
    public static ListNode fromLinkedList(final LinkedList<Integer> list) {

        if(list.isEmpty()) {
            return null;
        }

        ListNode listNode = null;
        for (Integer integer : List.copyOf(list).reversed()) {
            listNode = new ListNode(integer, listNode);
        }

        return listNode;
    }

    // static because ListNode is defined as above in the neetcode library
    // this can be copied into the class as required
    public static LinkedList<Integer> toLinkedList(final ListNode listNode) {

        final LinkedList<Integer> list = new LinkedList<>();

        ListNode iterator = listNode;
        while (iterator != null) {
            list.add(iterator.val);
            iterator = iterator.next;
        }

        return list;
    }
}
