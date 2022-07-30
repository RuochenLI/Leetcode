package exercises.leetcode801_1000;

/**
 * 839. Similar String Groups
 */
public class SimilarStringGroups_839 {
    private int[] root;
    private int count;

    public int numSimilarGroups(String[] strs) {
        count = strs.length;
        root = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            root[i] = i;
        }

        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (similar(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    private void union(final int x, final int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
            count--;
        }
    }

    private int find(final int node) {
        int current = node;
        while (root[current] != current) {
            root[current] = find(root[current]);
            current = root[current];
        }
        return current;
    }

    private boolean similar(final String p, final String q) {
        int countDiff = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != q.charAt(i)) {
                if (countDiff == 2) {
                    return false;
                }
                countDiff++;
            }
        }
        return countDiff == 0 || countDiff == 2;
    }
}
