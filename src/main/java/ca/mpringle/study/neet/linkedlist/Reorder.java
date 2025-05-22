package ca.mpringle.study.neet.linkedlist;

final class Reorder {


    /**
     * You are given the head of a singly linked-list.
     * <p>
     * The positions of a linked list of length = 7 for example, can initially be represented as:
     * <p>
     * [0, 1, 2, 3, 4, 5, 6]
     * <p>
     * Reorder the nodes of the linked list to be in the following order:
     * <p>
     * [0, 6, 1, 5, 2, 4, 3]
     * <p>
     * Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
     * <p>
     * [0, n-1, 1, n-2, 2, n-3, ...]
     * <p>
     * You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.
     * 4:50 -> 5:35
     */
    public static void reorderList(ListNode head) {

        ListNode first = head;

        // calculate length of list
        int size = 0;
        while (first != null) {
            first = first.next;
            size++;
        }

        ListNode[] nodes = new ListNode[size];

        int count = 0;

        first = head;

        while (first != null) {
            int index = count < size ? count : size - count % size - 1;
            nodes[index] = first;
            count += 2;
            first = first.next;
        }

        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        nodes[nodes.length - 1].next = null;
    }
}
