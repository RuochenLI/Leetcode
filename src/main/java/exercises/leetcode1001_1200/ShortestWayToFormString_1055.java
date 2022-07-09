package exercises.leetcode1001_1200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1055. Shortest Way to Form String
 */
public class ShortestWayToFormString_1055 {
    public int shortestWay(String source, String target) {
        int pt = 0;
        int ps = 0;
        int result = 0;;
        while (pt < target.length()) {
            if (!source.contains(target.substring(pt, pt + 1))) {
                return -1;
            }

            while (ps < source.length() && pt < target.length()) {
                if (source.charAt(ps) == target.charAt(pt)) {
                    ps++;
                    pt++;
                } else {
                    ps++;
                }
            }
            ps = 0;
            result++;
        }

        return result;
    }

    /**
     * Accept is not enough to get a hire. Interviewee 4 follow up
     * first opinion is that we can use two pointer , one iterate src, another iterate tar.
     * for each tar char, we move j until src[j] == tar[i], if j == src.length, res++, j = 0;
     * in this solution, we greedy match as many chars from src to tar as possible which can lead mininum use of src.
     * and we can build a set to save all the char in src, if there exists a char from tar which not exists in set, return -1.
     */

    public int shortestWay1(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        boolean[] map = new boolean[26];
        for (int i = 0; i < cs.length; i++)
            map[cs[i] - 'a'] = true;
        int j = 0, res = 1;
        for (int i = 0; i < ts.length; i++,j++) {
            if (!map[ts[i] - 'a']) return -1;
            while (j < cs.length && cs[j] != ts[i]) {
                j++;
            }
            if (j == cs.length) {
                j = -1;
                res++;
                i--;
            }
        }
        return res;
    }
    /**
     * follow up 1: yes, correct. could u implement it with O 1 space, which mean without set.
     * okay. without set, we need a way to make sure there is a char which not in src. we can iterate src completely. if the j not move, then we can return -1.
     */
    public int shortestWay2(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int res = 0;
        for (int i = 0; i < ts.length; ) {
            int oriI = i;
            for (int j = 0; j < cs.length; j++) {
                if (i < ts.length && cs[j] == ts[i])
                    i++;
            }
            if (i == oriI) return -1;
            res++;
        }
        return res;
    }
    /**
     * follow up 2: fine. what's the time complexity for above solutions. O(MN). could u make it better?
     * the time complexity is better than O (MN), should be O(logM * N) or O (N)
     * to find a logM way, it is easy to think of binary search. for each char in tar, we need loop from j to end, to find a char same as tar[i].
     * we can build a map which key is from 'a' -> 'z', the value is idx for this char in src. because idx is add from small to big. when we iterate tar[i], we can easily to find the tar[i]'s idx list. to search is there a idx is larger or equal than j+1. it is logM. and we have N char in tar, so the time complexity is N * logM
     * the time is to build the map is O(M);
     */
    public int shortestWay3(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int res = 1;
        List<Integer>[] idx = new List[26];
        for (int i = 0; i < 26; i++) idx[i] = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) idx[cs[i] - 'a'].add(i);
        int j = 0;
        for (int i = 0; i < ts.length; ) {
            List<Integer> tar = idx[ts[i] - 'a'];
            if (tar.isEmpty()) return -1;
            int k = Collections.binarySearch(tar, j);
            if (k < 0) k = -k - 1;
            if (k == tar.size()) {
                res++;
                j = 0;
            } else {
                j = tar.get(k) + 1;
                i++;
            }

        }
        return res;
    }
}
