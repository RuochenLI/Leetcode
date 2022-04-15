package interviews.facebook.panel;

import java.io.IOException;

public class MinimumLengthSubstrings {
    /**
     * Minimum Length Substrings
     * You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
     * Signature
     * int minLengthSubstring(String s, String t)
     * Input
     * s and t are non-empty strings that contain less than 1,000,000 characters each
     * Output
     * Return the minimum length of the substring of s. If it is not possible, return -1
     * Example
     * s = "dcbefebce"
     * t = "fd"
     * output = 5
     * Explanation:
     * Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.
     */
    int minLengthSubstring(String s, String t) {
        if (t.length() == 0) return 0;

        int[] count = new int[26];
        int deleted = 0;
        for (char c : t.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] > 0) {
                count[c - 'a']--;
                deleted++;
                if (deleted == t.length()) return i + 1;
            }
        }
        return -1;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) throws IOException {
        new MinimumLengthSubstrings().run();
    }
}
