package exercises.leetcode2001_2200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2184. Number of Ways to Build Sturdy Brick Wall
 */
public class NumberofWaystoBuildSturdyBrickWall_2184 {
    public int buildWall(int height, int width, int[] bricks) {
        List<Integer> validRows = new ArrayList<>();
        buildRows(0, width, bricks, 0, validRows);
        if (height == 1) {
            return validRows.size();
        }
        List<Map<Integer, Long>> dp = new ArrayList<>(height);
        dp.add(0, new HashMap<>());
        for (int row : validRows) {
            dp.get(0).put(row, 1L);
        }

        int result = 0;
        for (int i = 1; i < height; i++) {
            dp.add(i, new HashMap<>());
            for (final Integer stateA : validRows) {
                long sum = 0;
                for (final Integer stateB : validRows) {
                    if ((stateA & stateB) == 0) {
                        sum = (sum + dp.get(i - 1).get(stateB)) % 1_000_000_007;
                    }
                }
                dp.get(i).put(stateA, sum);
                if (i == height - 1) {
                    result = (int) ((result + sum) % 1_000_000_007);
                }
            }
        }
        return result;
    }

    // build row from right to left
    void buildRows(int currWidth, int width, int[] bricks, int rowMask, List<Integer> r) {
        for (int brick : bricks) {
            if (currWidth + brick == width) {
                r.add(rowMask);
            } else if (currWidth + brick < width) {
                buildRows(currWidth + brick, width, bricks, rowMask | (1 << (currWidth + brick)), r);
            }
        }
    }

    // better complexity
    /*
    - Find all the valid rows to build a row of bricks, use bits to mark the boundaries. We can use backtracking to do it. If the bricks are 1, 2 and the width is 3, the valid rows are [1, 2], [2, 1], [1, 1, 1].
    - Find all valid transitions from one row to another. Since the rows are represented as bits, it is easy to do. We can build r1 on top of r2, if r1 & r2 = 0
    - Build a wall from the bottom up using the valid transitions from one row to the next.
     */
    public int buildWall0(int height, int width, int[] bricks) {
        List<Integer> validRows = new ArrayList<>();
        buildRows(0, width, bricks, 0, validRows);
        Map<Integer, Long> dp = new HashMap<>();
        Map<Integer, List<Integer>> transitions = new HashMap<>();
        for (Integer row : validRows) {
            transitions.put(row, new ArrayList<>());
            dp.put(row, 1L);
        }
        for (Integer from : validRows) {
            for (Integer to : validRows) {
                if ((from & to) == 0) {
                    transitions.get(from).add(to);
                }
            }
        }
        while (--height > 0) {
            Map<Integer, Long> nextDp = new HashMap<>();
            for (Integer next : validRows) {
                long count = 0;
                for (Integer prev : transitions.get(next)) {
                    count = (count + dp.get(prev)) % 1_000_000_007;
                }
                nextDp.put(next, count);
            }
            dp = nextDp;
        }
        return (int) (dp.values().stream().mapToLong(n -> n).sum() % 1_000_000_007);
    }
}
