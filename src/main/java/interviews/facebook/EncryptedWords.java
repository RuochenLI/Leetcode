package interviews.facebook;

public class EncryptedWords {
    /**
     * Encrypted Words
     * You've devised a simple encryption method for alphabetic strings that shuffles the characters in such a way that the resulting string is hard to quickly read, but is easy to convert back into the original string.
     * When you encrypt a string S, you start with an initially-empty resulting string R and append characters to it as follows:
     * Append the middle character of S (if S has even length, then we define the middle character as the left-most of the two central characters)
     * Append the encrypted version of the substring of S that's to the left of the middle character (if non-empty)
     * Append the encrypted version of the substring of S that's to the right of the middle character (if non-empty)
     * For example, to encrypt the string "abc", we first take "b", and then append the encrypted version of "a" (which is just "a") and the encrypted version of "c" (which is just "c") to get "bac".
     * If we encrypt "abcxcba" we'll get "xbacbca". That is, we take "x" and then append the encrypted version "abc" and then append the encrypted version of "cba".
     * Input
     * S contains only lower-case alphabetic characters
     * 1 <= |S| <= 10,000
     * Output
     * Return string R, the encrypted version of S.
     * Example 1
     * S = "abc"
     * R = "bac"
     * Example 2
     * S = "abcd"
     * R = "bacd"
     * Example 3
     * S = "abcxcba"
     * R = "xbacbca"
     * Example 4
     * S = "facebook"
     * R = "eafcobok"
     */
    String findEncryptedWord(String s) {
        if (s.length() <= 2) return s;

        int mid = (s.length() + 1) / 2 - 1;
        return s.charAt(mid) +
                findEncryptedWord(s.substring(0, mid)) +
                findEncryptedWord(s.substring(mid + 1));
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String s_1 = "abc";
        String expected_1 = "bac";
        String output_1 = findEncryptedWord(s_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String expected_2 = "bacd";
        String output_2 = findEncryptedWord(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new EncryptedWords().run();
    }
}
