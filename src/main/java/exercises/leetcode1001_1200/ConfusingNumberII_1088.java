package exercises.leetcode1001_1200;

import java.util.Map;
import java.util.Set;

/**
 * 1088. Confusing Number II
 */
public class ConfusingNumberII_1088 {
    static Map<Integer, Integer> map = Map.of(0, 0, 1, 1, 6, 9, 8, 8, 9, 6);
    int res = 0;

    public int confusingNumberII(int N) {
        // begin with cur = 0
        helper(N, 0);
        return res;
    }

    private void helper(int N, long cur) {
        if (isConfusingNumber(cur)) {
            res++;
        }

        for (Integer i : map.keySet()) {
            long next = cur * 10 + i;
            if (next <= N && next != 0) {
                //System.err.println(next);
                helper(N, next);
            }
        }
    }

    private boolean isConfusingNumber(long cur) {
        // lets say curr = 69
        long src = cur;
        long strobogrammticRotatedNumber = 0;
        /* Since we rotate 180, least significant digit would become most significant digit in strobogrammatic number.
         * find each digit starting from least significant digit and get strobogrammatic digit. */
        while (cur > 0) {

            strobogrammticRotatedNumber = strobogrammticRotatedNumber * 10 +
                                          map.get((int) cur % 10); // 0*10+9%10 6 = 6   next loop 6*10 + 9 69
            //System.err.println(cur +" result = "+ strobogrammticRotatedNumber);
            cur /= 10;                                // 6            next loop
        }
        return strobogrammticRotatedNumber != src;
    }

    // my solution below
    int count = 0;
    Set<Character> candidates = Set.of('0', '1', '6', '8', '9');

    public int confusingNumberII0(int n) {
        StringBuilder sb = new StringBuilder();
        backtrace(sb, n);
        return count;
    }

    private void backtrace(final StringBuilder sb, int n) {
        for (final Character c : candidates) {
            if (sb.isEmpty() && c == '0') {
                continue;
            }

            sb.append(c);
            String s = sb.toString();
            long parsedS = Long.parseLong(s);
            if (parsedS <= n) {
                if (parsedS > 0 && isConfusingNumber(s)) {
                    count++;
                }
                backtrace(sb, n);
                ;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private boolean isConfusingNumber(final String s) {
        for (int left = 0, right = s.length() - 1; left <= right; left++, right--) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if (leftC != rightC) {
                if (leftC == '6' && rightC == '9' || leftC == '9' && rightC == '6') {
                    continue;
                }
                return true;
            } else {
                if (leftC == '6' || leftC == '9') {
                    return true;
                }
            }
        }
        return false;
    }
}
