package exercises.leetcode1201_1400;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 1387. Sort Integers by The Power Value
 */
public class SortIntegersbyThePowerValue_1387 {
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> powerMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,
                                                           (a, b) -> Objects.equals(powerMap.get(a), powerMap.get(b))
                                                                     ? b - a
                                                                     : powerMap.get(b) - powerMap.get(a));
        powerMap.put(1, 0);
        for (int i = lo; i <= hi; i++) {
            int power = calculatePower(powerMap, i);
            if (queue.size() < k) {
                queue.offer(i);
            } else if (powerMap.get(queue.peek()) > power) {
                queue.poll();
                queue.offer(i);
            }
        }
        return queue.peek();
    }

    private int calculatePower(final Map<Integer, Integer> powerMap, final int num) {
        if (powerMap.containsKey(num)) {
            return powerMap.get(num);
        }

        int power = 0;
        if (num % 2 == 0) {
            power = calculatePower(powerMap, num / 2) + 1;
        } else {
            power = calculatePower(powerMap, num * 3 + 1) + 1;
        }
        powerMap.put(num, power);
        return power;
    }
}
