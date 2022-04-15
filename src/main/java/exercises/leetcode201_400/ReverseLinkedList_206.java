package exercises.leetcode201_400;

import helper.ListNode;

public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null ||head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
