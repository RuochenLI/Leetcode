package exercises.leetcode1401_1600;

public class ConsecutiveCharacters1446 {
    public int maxPower(String s) {
        if (s.length() == 0) return 0;
        int result = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                result = Math.max(result, count);
            } else {
                count = 1;
            }
        }
        return result;
    }
}
