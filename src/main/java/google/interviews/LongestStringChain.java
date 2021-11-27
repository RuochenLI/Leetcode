package google.interviews;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {


    public int longestStrChain(String[] words) {
        int ans = 0;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int[] dp = new int[words.length];
        for (int i = words.length - 2; i >= 0; i--) {
            for (int j= i + 1; j < words.length; j++) {
                if (isPredecessor(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans + 1;
    }

    private boolean isPredecessor(String word1, String word2) {
        if (word1.length() + 1 != word2.length()) { return false; }
        int countDiff = 0;
        int pointer = 0;
        while (pointer < word1.length() && countDiff < 2) {
            if (word1.charAt(pointer) == word2.charAt(pointer + countDiff)) {
                pointer++;
            } else {
                countDiff++;
            }
        }
        return countDiff <= 1;
    }
}
