package exercises.leetcode1_200;

import helper.ListNode;

public class LinkedListCycleII_142 {
    /**
     *  Floyd's Cycle Detection Algorithm same as Linked List Cycle 141
     *
     *  x denotes the length of the linked list before starting the circle
     *  y denotes the distance from the start of the cycle to where slow and fast met
     *  C denotes the length of the cycle
     *
     *  when they meet, slow traveled (x + y) steps while fast traveled 2 * (x + y) steps, and the extra distance (x + y) must be a multiple of the circle length C
     *  so we have x + y = N * C, let slow continue to travel from y and after x more steps, slow will return to the start of the cycle.
     *  At the same time, according to the definition of x, head will also reach the start of the cycle after moving x steps.
     *  so if head and slow start to move at the same time, they will meet at the start of the cycle, that is the answer.
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null || fast != slow) return null;
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
