package google.interviews;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[58];
        int ans = 0;
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }

        for (int i = 0; i < 58; i ++) {
            ans = ans + 2 * (count[i] / 2);
        }

        return ans == s.length() ? ans : ans + 1;
    }
}
