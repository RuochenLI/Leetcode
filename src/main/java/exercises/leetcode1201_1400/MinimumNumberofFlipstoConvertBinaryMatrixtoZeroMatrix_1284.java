package exercises.leetcode1201_1400;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix_1284 {
    public int minFlips(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]);
            }
        }
        String s = sb.toString();

        Set<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(s);
        int nbSteps = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String current = queue.poll();
                visited.add(current);
                if (isZeroMatrix(current)) {
                    return nbSteps;
                }
                for (int j = 0; j < current.length(); j++) {
                    String newS = flip(current, j, m, n);
                    if (!visited.contains(newS)) {
                        queue.offer(newS);
                    }
                }
            }
            nbSteps++;
        }

        return -1;
    }

    private boolean isZeroMatrix(final String s) {
        return s.indexOf('1') == -1;
    }

    private char flipOnePosition(final char c) {
        return c == '1' ? '0' : '1';
    }

    private String flip(final String s, final int position, final int m, final int n) {
        char[] chars = s.toCharArray();
        chars[position] = flipOnePosition(chars[position]);

        int up = position - n;
        if (up >= 0) {
            chars[up] = flipOnePosition(chars[up]);
        }

        int down = position + n;
        if (down < s.length()) {
            chars[down] = flipOnePosition(chars[down]);
        }

        if (position % n != 0) {
            int left = position - 1;
            chars[left] = flipOnePosition(chars[left]);
        }

        if (position % n != n - 1) {
            int right = position + 1;
            chars[right] = flipOnePosition(chars[right]);
        }
        return String.valueOf(chars);
    }

    // bit manipulation
    private static final int[][] d = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int minFlips1(int[][] mat) {
        int start = 0, m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                start |= mat[i][j] << (i * n + j); // convert the matrix to an int.
        Queue<Integer> q = new LinkedList<>(List.of(start));
        Set<Integer> seen = new HashSet<>(q);
        for (int step = 0; !q.isEmpty(); ++step) {
            for (int sz = q.size(); sz > 0; --sz) {
                int cur = q.poll();
                if (cur == 0) // All 0s matrix found.
                    return step;
                for (int i = 0; i < m; ++i) { // traverse all m * n bits of cur.
                    for (int j = 0; j < n; ++j) {
                        int next = cur;
                        for (int k = 0; k < 5; ++k) { // flip the cell (i, j) and its neighbors.
                            int r = i + d[k][0], c = j + d[k][1];
                            if (r >= 0 && r < m && c >= 0 && c < n)
                                // Use next ^ 1 << k (where k = i * n + j) to flip kth bit of next, which is equal to flipping the corresponding cell (i, j) in the matrix.
                                next ^= 1 << (r * n + c);
                        }
                        if (seen.add(next)) // seen it before ?
                            q.offer(next); // no, put it into the Queue.
                    }
                }
            }
        }
        return -1; // impossible to get all 0s matrix.
    }
}
