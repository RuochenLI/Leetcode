package exercises.leetcode1001_1200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1101. The Earliest Moment When Everyone Become Friends
 */
public class TheEarliestMomentWhenEveryoneBecomeFriends_1101 {
    public int earliestAcq(int[][] logs, int n) {
        int[] root = new int[n];
        int[] nbFriends = new int[n];
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            root[i] = i;
            nbFriends[i] = 1;
        }

        for (int[] log : logs) {
            int count = union(root, log[1], log[2], nbFriends);
            if (count == n) {
                return log[0];
            }
        }

        return -1;
    }

    public int find(int people, int[] root) {
        int pt = people;
        while (root[pt] != pt) {
            pt = root[pt];
        }

        return pt;
    }

    public int union(int[] root, int p, int q, int[] nbFriends) {
        int parentP = find(p, root);
        int parentQ = find(q, root);
        if (parentP != parentQ) {
            root[parentQ] = parentP;
            nbFriends[parentP] = nbFriends[parentQ] + nbFriends[parentP];
            return nbFriends[parentP];
        }
        return -1;
    }
}
