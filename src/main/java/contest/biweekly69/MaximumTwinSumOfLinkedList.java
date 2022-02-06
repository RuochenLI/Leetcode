package contest.biweekly69;

import helper.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumOfLinkedList {

    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            list.add(pointer.val);
            pointer = pointer.next;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <list.size() / 2; i++) {
            max = Math.max(max, list.get(i) + list.get(list.size() - i - 1));
        }
        return max;
    }
}
