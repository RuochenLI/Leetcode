package exercises.leetcode2200_2400;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 2242. Maximum Score of a Node Sequence
 */
public class MaximumScoreOfANodeSequence_2242 {
    public int maximumScore(int[] scores, int[][] edges) {
        PriorityQueue<Integer>[] topNeighbours = new PriorityQueue[scores.length];
        for (int i = 0; i < scores.length; i++) {
            topNeighbours[i] = new PriorityQueue<>(4, Comparator.comparingInt(a -> scores[a]));
        }
        for (int[] edge : edges) {
            topNeighbours[edge[0]].offer(edge[1]);
            topNeighbours[edge[1]].offer(edge[0]);
            if (topNeighbours[edge[0]].size() > 3) {
                topNeighbours[edge[0]].poll();
            }
            if (topNeighbours[edge[1]].size() > 3) {
                topNeighbours[edge[1]].poll();
            }
        }
        int res = -1;
        for (int[] edge : edges) {
            for (int neighbourI : topNeighbours[edge[0]]) {
                for (int neighbourJ : topNeighbours[edge[1]]) {
                    // Set<Integer> set = Sets.newHashSet(edge[0], edge[1], neighbourI, neighbourJ);
                    //if (set.size() == 4) {
                    if (neighbourI != neighbourJ &&
                        neighbourI != edge[0] &&
                        neighbourI != edge[1] &&
                        neighbourJ != edge[0] &&
                        neighbourJ != edge[1]) {
                        res = Math.max(res,
                                       scores[neighbourI] + scores[neighbourJ] + scores[edge[0]] + scores[edge[1]]);
                    }
                }
            }
        }
        return res;
    }
}
