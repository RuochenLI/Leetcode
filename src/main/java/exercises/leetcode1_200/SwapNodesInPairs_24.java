package exercises.leetcode1_200;

import helper.ListNode;

public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode pointer = dummyHead;
        while (pointer.next != null && pointer.next.next != null) {
            ListNode tmp = pointer.next;
            pointer.next = pointer.next.next;
            tmp.next = pointer.next.next;
            pointer.next.next = tmp;
            pointer = pointer.next.next;
        }
        return dummyHead.next;
    }
}
