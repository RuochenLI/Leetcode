package exercises.leetcode1_200;

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] target = new int[53];
        int[] expected = new int[53];
        int min = s.length();
        String result = "";
        for (final char c : t.toCharArray()) {
            target[getHash(c)]++;
        }

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            expected[getHash(s.charAt(right))]++;
            while (found(target, expected)) {
                if (right - left < min){
                    min = right - left;
                    result = s.substring(left, right + 1);
                }
                expected[getHash(s.charAt(left))]--;
                left++;
            }
            right++;
        }
        return result;
    }

    private boolean found(final int[] target, final int[] expected) {
        for (int i = 0; i <= 52; i++) {
            if (target[i] > expected[i]){
                return false;
            }
        }
        return true;
    }

    public int getHash(char c) {
        if (c >= 'a' && c <= 'z' ) {
            return c - 'a' + 26;
        }

        return c - 'A';
    }
}
