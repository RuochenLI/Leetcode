package exercises.leetcode1601_1800;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javafx.util.Pair;

/**
 * 1632. Rank Transform of a Matrix
 */
public class RankTransformofaMatrix_1632 {
//    Map<Integer, Integer> parents;
//
//    public int[][] matrixRankTransform(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int[] rank = new int[n + m];
//        Map<Integer, List<int[]>> invMap = new TreeMap<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                invMap.computeIfAbsent(matrix[i][j], l -> new ArrayList<>()).add(new int[]{i, j});
//            }
//        }
//        for (int key : invMap.keySet()) {
//            int[] rank2 = rank.clone();
//            for (int[] coord : invMap.get(key)) {
//                Pair<Integer, Integer> res = union(coord[0], ~coord[1]);
//                rank2[res.getValue()] = Math.max(rank2[res.getValue()], rank2[res.getKey()]);
//            }
//            for (Pair<Integer, Integer> coord : invMap.get(key)) {
//                rank[coord.getKey()] = rank[coord.getValue() + n] = matrix[coord.getKey()][coord.getValue()] = rank2[uf.find(coord.getKey())] + 1;
//            }
//        }
//        return matrix;
//    }
//
//    public int find(int index) {
//        if (!parents.containsKey(index)) {
//            parents.put(index, index);
//            return index;
//        }
//
//        if (index != parents.get(index)) {
//            parents.put(index, find(parents.get(index)));
//        }
//        return parents.get(index);
//    }
//
//    public void union(int x, int y) {
//        int parentX = find(x);
//        int parentY = find(y);
//        if (parentX != parentY) {
//            parents.put(parentX, parentY);
//        }
//    }


//    // implement find and union
//    public int find(Map<Integer, Integer> UF, int x) {
//        if (x != UF.get(x)) {
//            UF.put(x, find(UF, UF.get(x)));
//        }
//        return UF.get(x);
//    }
//
//    public void union(Map<Integer, Integer> UF, int x, int y) {
//        if (!UF.containsKey(x)) {
//            UF.put(x, x);
//        }
//        if (!UF.containsKey(y)) {
//            UF.put(y, y);
//        }
//        UF.put(find(UF, x), find(UF, y));
//    }
//
//    public int[][] matrixRankTransform(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        // link row and col together
//        Map<Integer, Map<Integer, Integer>> UFs = new HashMap<>();
//        // UFs.get(v): the Union-Find of value v
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int v = matrix[i][j];
//                if (!UFs.containsKey(v)) {
//                    UFs.put(v, new HashMap<>());
//                }
//                // union i to j
//                union(UFs.get(v), i, ~j);
//            }
//        }
//
//        // put points into `value2index` dict, grouped by connection
//        // use TreeMap to help us sort the key automatically
//        SortedMap<Integer, Map<Integer, List<int[]>>> value2index = new TreeMap<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int v = matrix[i][j];
//                if (!value2index.containsKey(v)) {
//                    value2index.put(v, new HashMap<>());
//                }
//                Map<Integer, List<int[]>> indexes = value2index.get(v);
//                int f = find(UFs.get(v), i);
//                if (!indexes.containsKey(f)) {
//                    indexes.put(f, new ArrayList<>());
//                }
//                indexes.get(f).add(new int[] { i, j });
//            }
//        }
//
//        int[][] answer = new int[m][n]; // the required rank matrix
//        int[] rowMax = new int[m]; // rowMax[i]: the max rank in i row
//        int[] colMax = new int[n]; // colMax[j]: the max rank in j col
//        for (int v : value2index.keySet()) {
//            // update by connected points with same value
//            for (List<int[]> points : value2index.get(v).values()) {
//                int rank = 1;
//                for (int[] point : points) {
//                    rank = Math.max(rank, Math.max(rowMax[point[0]], colMax[point[1]]) + 1);
//                }
//                for (int[] point : points) {
//                    answer[point[0]][point[1]] = rank;
//                    // update rowMax and colMax
//                    rowMax[point[0]] = Math.max(rowMax[point[0]], rank);
//                    colMax[point[1]] = Math.max(colMax[point[1]], rank);
//                }
//            }
//        }
//        return answer;
//    }

}
