package exercises.leetcode1801_2000;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 1825. MKAverage
 */
public class MKAverage {
    // idea - one queue to track the "stream"
    // 3 TreeMap keep track the k largest and smallest and middle ones
    // First we put one number to top TreeMap, if it larger than k, then we pick the smallest one to bottom TreeMap, if it larger than k, then we pick largest to middle.
    //If the queue is larger than m, then we need to remove one from top, middle or bottom. If we remove from top, then pick the largest number from middle, if we remove from bottom, then we pick the smallest one from middle.
    private int m, k;
    private TreeMap<Integer, Integer> top, mid, bot;
    private int lenTop, lenBot;
    private Queue<Integer> que;
    private long sum;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;

        top = new TreeMap<>();
        mid = new TreeMap<>();
        bot = new TreeMap<>();
        lenTop = 0;
        lenBot = 0;

        que = new LinkedList<>();

        sum = 0;
    }

    public void addElement(int num) {
        que.offer(num);

        // if more than m, we need to shrink - poll out the first element in que
        // while keep 3 maps updated
        if (que.size() > m) {
            shrink();
        }

        // ensure top contains the k largest, so on..
        balance(num);
    }

    private void shrink() {
        if (que.size() <= m) {
            return;
        }
        int num = que.poll();
        // check 3 cases - if in the map, remove it and shift the
        // proper num into it
        if (top.containsKey(num)) {
            remove(top, num);
            // as remove from top, we add one "backup"
            // from the end of middle parts
            int last = mid.lastKey();
            remove(mid, last);
            sum -= last;
            add(top, last);
        } else if (bot.containsKey(num)) {
            remove(bot, num);
            // smiliarly here, use first in mid as "backup"
            int first = mid.firstKey();
            remove(mid, first);
            sum -= first;
            add(bot, first);
        } else if (mid.containsKey(num)) {
            remove(mid, num);
            sum -= num;
        }
    }

    private void balance(int num) {
        // add the num from top to mid to bot
        // if top <= k, just add it
        top.put(num, top.getOrDefault(num, 0) + 1);
        lenTop++;
        if (lenTop <= k) {
            return;
        }

        // if top is "full", pop the first/smallest in top out
        // add into bot for a try
        int first = top.firstKey();
        remove(top, first);
        lenTop--;

        add(bot, first);
        lenBot++;
        // if bot also full
        // pop the largest of bot into middle part
        if (lenBot > k) {
            int last = bot.lastKey();
            remove(bot, last);
            lenBot--;

            add(mid, last);
            sum += last;
        }
    }

    private void remove(TreeMap<Integer, Integer> map, int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
        }
    }

    private void add(TreeMap<Integer, Integer> map, int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public int calculateMKAverage() {
        return que.size() < m ? -1 : (int) (sum / (m - 2 * k));
    }
    /*
    private final Queue<Integer> queue;
    private final TreeMap<Integer, Integer> valueCount;
    private final int m;
    private int sum;
    private final int k;

    public MKAverage(int m, int k) {
        this.queue = new ArrayDeque<>(m);
        this.valueCount = new TreeMap<>();
        this.m = m;
        this.sum = 0;
        this.k = k;
    }

    public void addElement(int num) {
        if (!this.queue.isEmpty() && this.queue.size() == this.m) {
            int firstInQueue = this.queue.poll();
            int occ = this.valueCount.get(firstInQueue) - 1;
            sum -= firstInQueue;
            if (occ == 0) {
                this.valueCount.remove(firstInQueue);
            } else {
                this.valueCount.put(firstInQueue, occ);
            }
        }
        this.queue.offer(num);
        this.valueCount.put(num, this.valueCount.getOrDefault(num, 0) + 1);
        sum += num;
    }

    public int calculateMKAverage() {
        if (this.queue.isEmpty() || this.queue.size() < m) {
            return -1;
        }
        int tmp = this.sum;
        List<Map.Entry<Integer, Integer>> entryList = this.valueCount.entrySet().stream().toList();
        int minIndex = 0;
        int maxIndex = entryList.size() - 1;
        int minCount = entryList.get(0).getValue();
        int maxCount = entryList.get(maxIndex).getValue();
        for (int i = 0; i < k; i++) {
            tmp -= (entryList.get(minIndex).getKey() + entryList.get(maxIndex).getKey());
            minCount--;
            maxCount--;
            if (minCount == 0) {
                minIndex++;
                minCount = entryList.get(minIndex).getValue();
            }
            if (maxCount == 0) {
                maxIndex--;
                maxCount = entryList.get(maxIndex).getValue();
            }
        }

        return tmp / (m - 2 * k);
    }*/
}
