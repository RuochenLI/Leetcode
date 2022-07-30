package exercises.leetcode1801_2000;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1820. Maximum Number of Accepted Invitations
 */
public class MaximumNumberOfAcceptedInvitations_1820 {
    /**
     * Maximum bipartite matching
     *
     * https://www.geeksforgeeks.org/maximum-bipartite-matching/
     */
    public int maximumInvitations(int[][] grid) {
        int nbBoys = grid.length;
        int nbGirls = grid[0].length;
        int[] girlInvited = new int[nbGirls];
        for (int i = 0; i < nbGirls; i++) {
            girlInvited[i] = -1;
        }
        int invitations = 0;
        for (int i = 0; i < nbBoys; i++) {
            Set<Integer> seenGirl = new HashSet<>();
            if (dfs(grid, i, seenGirl, girlInvited, nbGirls)) {
                invitations++;
            }
        }
        return invitations;
    }

    private boolean dfs(int[][] grid, int boy, Set<Integer> seenGirl, int[] girlInvited, final int nbGirls) {
        for (int i = 0; i < nbGirls; i++) {
            if (grid[boy][i] == 1 && !seenGirl.contains(i)) {
                seenGirl.add(i);
                // if the girl i, is not invited or previously inviting boy has an alternative girl available
                if (girlInvited[i] == -1 || dfs(grid, girlInvited[i], seenGirl, girlInvited, nbGirls)) {
                    girlInvited[i] = boy;
                    return true;
                }
            }
        }
        return false;
    }

    public int maximumInvitations0(int[][] grid) {
        Map<Integer, Set<Integer>> invitesByGirls = new HashMap<>();
        PriorityQueue<Integer> girlsQueue = new PriorityQueue<>(Comparator.comparingInt(a -> invitesByGirls.get(a)
                                                                                                           .size()));

        for (int i = 0; i < grid[0].length; i++) {
            Set<Integer> bos = new HashSet<>();
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    bos.add(j);
                }
            }
            if (!bos.isEmpty()) {
                invitesByGirls.put(i, bos);
                girlsQueue.offer(i);
            }
        }

        int count = 0;
        while (!girlsQueue.isEmpty()) {
            int girl = girlsQueue.poll();
            count++;
            int boy = invitesByGirls.get(girl).iterator().next();
            for (int i = 0; i < grid[0].length; i++) {
                if (!girlsQueue.isEmpty() && grid[boy][i] == 1 && i != girl) {
                    invitesByGirls.get(i).remove(boy);
                    girlsQueue.remove(i);
                    if (!invitesByGirls.get(i).isEmpty()) {
                        girlsQueue.offer(i);
                    }
                }
            }
        }

        return count;
    }
}
