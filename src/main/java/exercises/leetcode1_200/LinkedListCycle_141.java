package exercises.leetcode1_200;

import helper.ListNode;

public class LinkedListCycle_141 {
    /**
     * Floyd's Cycle Detection Algorithm.
     *
     * We consider 2 pointers, fast and slow:
     *
     * slow pointer will move by one node
     * fast pointer will move by two nodes
     * Think of two cars running in a race track (one fast and second slow).
     * The fast car will get far ahead of slow car at first,
     * but after one/few laps, the fast car will again cross the slow car,
     * as they are running in a circle/loop
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
