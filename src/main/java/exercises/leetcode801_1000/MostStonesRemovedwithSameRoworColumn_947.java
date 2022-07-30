package exercises.leetcode801_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 947. Most Stones Removed with Same Row or Column
 */
public class MostStonesRemovedwithSameRoworColumn_947 {
    Map<Integer, Integer> parents;
    int nbIslands;

    public int removeStones(int[][] stones) {
        parents = new HashMap<>();
        nbIslands = 0;
        for (int[] stone : stones) {
            union(stone[0], ~stone[1]);
        }
        return stones.length - nbIslands;
    }

    public int find(int index) {
        if (!parents.containsKey(index)) {
            parents.put(index, index);
            nbIslands++;
            return index;
        }

        if (index != parents.get(index)) {
            parents.put(index, find(parents.get(index)));
        }
        return parents.get(index);
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            parents.put(parentX, parentY);
            nbIslands--;
        }
    }



//    /*
//    Connected stones can be reduced to 1 stone,
//    the maximum stones can be removed = stones number - islands number.
//    so just count the number of "islands".
//     */ Map<Integer, Integer> f = new HashMap<>();
//    int islands = 0;
//
//    public int removeStones0(int[][] stones) {
//        /*
//            stones[i] is the i-th stone.
//            stones[i][0] is the row of the i-th stone
//            stones[i][1] is the column of the i-th stone
//
//            unary operator tilde (~) is equivalent to x = -x -1. This operation is being used to represent both row and columns in the same dimension. We could have also used:
//            row_rep = row_id
//            col_rep = 10000+col_id
//
//            In all,
//            union(stones[i][0], stones[i][1] ) joins the row and the column of the i-th stone.
//        */
//        for (int i = 0; i < stones.length; ++i) {
//            union(stones[i][0], ~stones[i][1]);
//        }
//        return stones.length - islands;
//    }
//
//    public int find(int x) {
//        if (f.putIfAbsent(x, x) == null) {
//            islands++;
//        }
//        if (x != f.get(x)) {
//            f.put(x, find(f.get(x)));
//        }
//        return f.get(x);
//    }
//
//    public void union(int x, int y) {
//        x = find(x);
//        y = find(y);
//        if (x != y) {
//            f.put(x, y);
//            islands--;
//        }
//    }
}
