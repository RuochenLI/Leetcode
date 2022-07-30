package exercises.leetcode2001_2200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2174. Remove All Ones With Row and Column Flips II
 */
public class RemoveAllOnesWithRowandColumnFlipsII_2174 {
    public int removeOnes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<String> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (final int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                sb.append(ints[j]);
            }
        }
        queue.offer(sb.toString());
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                long bitState = Long.parseLong(current, 2);
                if (bitState == 0) {
                    return step;
                }
                visited.add(bitState);
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        if (current.charAt(j * n + k) == '1') {
                            char[] charArray = current.toCharArray();
                            for (int l = 0; l < n; l++) {
                                charArray[j * n + l] = '0';
                            }
                            for (int l = 0; l < m; l++) {
                                charArray[l * n + k] = '0';
                            }
                            String newState = String.valueOf(charArray);
                            long newStateInBit = Long.parseLong(newState, 2);
                            if (!visited.contains(newStateInBit)) {
                                queue.offer(newState);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public int removeOnes1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long state = convertGridToBit(grid, m, n);
        Queue<Long> q = new LinkedList<>();
        q.add(state);
        int step = 0;
        HashSet<Long> seen = new HashSet<>();
        seen.add(state);
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                long cur = q.remove();
                if (cur == 0) {
                    return step;
                }
                ArrayList<Integer> lst = new ArrayList<>();
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        int k = i * n + j;
                        if ((cur & (1L << k)) > 0) {
                            lst.add(k);
                        }
                    }
                }
                for (Integer e : lst) {
                    int r = e / n, c = e % n;
                    long newState = cur;
                    for (int i = 0; i < n; ++i) {
                        int k = r * n + i;
                        newState &= (~(1L << k));
                    }
                    for (int i = 0; i < m; ++i) {
                        int k = i * n + c;
                        newState &= (~(1L << k));
                    }
                    if (!seen.contains(newState)) {
                        q.add(newState);
                        seen.add(newState);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private long convertGridToBit(final int[][] grid, final int m, final int n) {
        long state = 0;
        // Convert grid to bit, the bit is 1 if grid[i][j] is 1
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int k = i * n + j;
                state |= (1L << k) * grid[i][j];
            }
        }
        return state;
    }
}
