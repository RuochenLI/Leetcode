package exercises.leetcode1601_1800;

import java.util.Arrays;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique_1647 {
    public int minDeletions(String s) {
        int[] occ = new int[26];
        for (char c : s.toCharArray()) {
            occ[c - 'a']++;
        }
        Arrays.sort(occ);
        int result = 0;
        for (int i = 25; i > 0; i--) {
            if (occ[i] == 0 && occ[i - 1] == 0) break;
            if (occ[i] == occ[i - 1]){
                result++;
                occ[i - 1]--;
            } else if (occ[i - 1] > occ[i]) {
                if (occ[i] == 0) {
                    result = result + occ[i - 1];
                    occ[i - 1] = 0;
                } else {
                    result = result + (occ[i - 1] - occ[i]) + 1;
                    occ[i - 1] = occ[i] - 1;
                }
            }
        }
        return result;
    }
}
