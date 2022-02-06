package interviews.google;

public class LongestPalindromeSubstring {

    int maxX = 0;
    int maxY = 0;
    int max = 0;

    public String longestPalindrome(String s) {
        findSolution(0, s.length() - 1, s);
        return s.substring(maxX, maxY + 1);
    }

    private void findSolution(int x, int y, String s) {
        if (x > y || y - x + 1 <= max) return;

        if (x == y) {
            max = 1;
            maxX = x;
            maxY = y;
            return;
        }

        if (s.charAt(x) == s.charAt(y)) {
            int left = x;
            int right = y;
            while (left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            if (left >= right) {
                max = y - x + 1;
                maxX = x;
                maxY = y;
            }
        }

        findSolution(x, y - 1, s);
        findSolution(x + 1, y, s);
    }

    private int lo, maxLen;

    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
