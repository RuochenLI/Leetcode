package exercises.leetcode1_200;

import helper.ListNode;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = l1.val + l2.val;
        ListNode result = new ListNode(tmp % 10);
        ListNode pointer = result;
        int remaining = tmp / 10;
        while (l1.next != null || l2.next != null) {

            l1 = l1.next != null ? l1.next : new ListNode(0);
            l2 = l2.next != null ? l2.next : new ListNode(0);
            tmp = l1.val + l2.val + remaining;
            System.out.println(tmp);
            pointer.next = new ListNode(tmp % 10);
            remaining = tmp / 10;
            pointer = pointer.next;
        }
        if (remaining != 0) {
            pointer.next = new ListNode(remaining);
        }
        return result;
    }
}
