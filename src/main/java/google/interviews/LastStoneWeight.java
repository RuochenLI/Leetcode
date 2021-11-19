package google.interviews;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones.length <= 0) return 0;

        PriorityQueue<Integer> priorityStones = new PriorityQueue<>(Collections.reverseOrder());
        for (final int stone : stones) {
            priorityStones.add(stone);
        }

        while (priorityStones.size() > 1) {
            int bigger = priorityStones.poll();
            int smaller = priorityStones.poll();
            priorityStones.add((bigger - smaller));
        }
        return priorityStones.poll();
    }
}
