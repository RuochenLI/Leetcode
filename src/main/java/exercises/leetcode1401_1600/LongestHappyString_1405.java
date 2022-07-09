package exercises.leetcode1401_1600;

import java.util.PriorityQueue;

public class LongestHappyString_1405 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder builder = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((count1, count2) -> Integer.compare(count2.count, count1.count));

        if (a > 0)
            pq.add(new Pair('a', a));
        if (b > 0)
            pq.add(new Pair('b', b));
        if (c > 0)
            pq.add(new Pair('c', c));

        while (pq.size() > 1) {
            Pair pair_one = pq.poll();
            if (pair_one.count >= 2) {
                builder.append(pair_one.ch);
                builder.append(pair_one.ch);
                pair_one.count -= 2;
            } else {
                builder.append(pair_one.ch);
                pair_one.count -= 1;
            }

            Pair pair_two = pq.poll();
            if (pair_two.count >= 2 && pair_one.count < pair_two.count) {
                builder.append(pair_two.ch);
                builder.append(pair_two.ch);
                pair_two.count -= 2;
            } else {
                builder.append(pair_two.ch);
                pair_two.count -= 1;
            }

            if (pair_one.count > 0)
                pq.add(pair_one);
            if (pair_two.count > 0)
                pq.add(pair_two);
        }

        if (!pq.isEmpty()) {
            if (builder.length() == 0 || builder.charAt(builder.length() - 1) != pq.peek().ch) {
                if (pq.peek().count >= 2) {
                    builder.append(pq.peek().ch);
                    builder.append(pq.peek().ch);
                } else {
                    builder.append(pq.peek().ch);
                }
            }
        }
        return builder.toString();
    }

    static class Pair {
        public Character ch;
        int count;

        public Pair(Character ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
