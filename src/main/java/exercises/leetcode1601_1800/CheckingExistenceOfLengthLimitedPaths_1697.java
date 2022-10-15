package exercises.leetcode1601_1800;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1697. Checking Existence of Edge Length Limited Paths
 */
public class CheckingExistenceOfLengthLimitedPaths_1697 {
    int[] root;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        root = new int[n];
        Integer[] edgeIndexes = new Integer[edgeList.length];
        Integer[] queryIndexes = new Integer[queries.length];
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int i = 0; i < edgeList.length; i++) {
            edgeIndexes[i] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            queryIndexes[i] = i;
        }
        Arrays.sort(edgeIndexes, Comparator.comparingInt(a -> edgeList[a][2]));
        Arrays.sort(queryIndexes, Comparator.comparingInt(a -> queries[a][2]));

        int pt = 0;
        for (int i = 0; i < queries.length; i++) {
            while (pt < edgeList.length && edgeList[edgeIndexes[pt]][2] < queries[queryIndexes[i]][2]) {
                union(edgeList[edgeIndexes[pt]][0], edgeList[edgeIndexes[pt]][1]);
                pt++;
            }
            result[i] = find(queries[queryIndexes[i]][0]) == find(queries[queryIndexes[i]][1]);
        }
        return result;
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            root[rootA] = rootB;
        }
    }

    private int find(int a) {
        int pt = a;
        if (root[pt] != pt) {
            root[pt] = find(root[pt]);
            pt = root[pt];
        }
        return pt;
    }
}
