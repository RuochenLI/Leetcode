package exercises.leetcode401_600;

import java.util.HashMap;
import java.util.Map;

/**
 * 471. Encode String with Shortest Length
 */
public class EncodeStringWithShortestLength {
    Map<String, String> map = new HashMap<>();

    public String encode(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() <= 4) {
            return s;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        String ret = s;
        for (int k = s.length() / 2; k < s.length(); k++) {
            String pattern = s.substring(k);
            int times = countRepeat(s, pattern);
            if (times * pattern.length() != s.length()) {
                continue;
            }
            String candidate = times + "[" + encode(pattern) + "]";
            if (candidate.length() < ret.length()) {
                ret = candidate;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            String left = encode(s.substring(0, i));
            String right = encode(s.substring(i));
            String candidate = left + right;
            if (candidate.length() < ret.length()) {
                ret = candidate;
            }
        }
        map.put(s, ret);
        return ret;
    }

    private int countRepeat(String s, String pattern) {
        int times = 0;
        while (s.length() >= pattern.length()) {
            String sub = s.substring(s.length() - pattern.length());
            if (sub.equals(pattern)) {
                times++;
                s = s.substring(0, s.length() - pattern.length());
            } else {
                return times;
            }
        }
        return times;
    }

    public String encode0(String s) {
        String[][] dp = new String[s.length()][s.length()];

        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                String substr = s.substring(i, j + 1);
                // Checking if string length < 5. In that case, we know that encoding will not help.
                if (j - i < 4) {
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;
                    // Loop for trying all results that we get after dividing the strings into 2 and combine the   results of 2 substrings
                    for (int k = i; k < j; k++) {
                        if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }

                    // Loop for checking if string can itself found some pattern in it which could be repeated.
                    for (int k = 0; k < substr.length(); k++) {
                        String repeatStr = substr.substring(0, k + 1);
                        if (substr.length() % repeatStr.length() == 0 &&
                            substr.replaceAll(repeatStr, "").length() == 0) {
                            String ss = substr.length() / repeatStr.length() + "[" + dp[i][i + k] + "]";
                            if (ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                            }
                        }
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
