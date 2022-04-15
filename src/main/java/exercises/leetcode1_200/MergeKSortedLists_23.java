package exercises.leetcode1_200;

import java.util.Comparator;
import java.util.PriorityQueue;

import helper.ListNode;

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (final ListNode node : lists) {
            if (node != null) queue.offer(node);
        }
        ListNode head = new ListNode();
        ListNode node = head;
        while (!queue.isEmpty()) {
            ListNode nextNode = queue.poll();
            node.next = nextNode;
            node = node.next;
            if (nextNode.next != null) {
                queue.offer(nextNode.next);
            }
        }
        node.next = null;

        return head.next;
    }
}
