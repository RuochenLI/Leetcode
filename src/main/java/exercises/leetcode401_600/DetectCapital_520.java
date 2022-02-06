package exercises.leetcode401_600;

public class DetectCapital_520 {
    public boolean detectCapitalUse(String word) {
        int low = 0;
        int high = 0;
        boolean firstCapital = false;
        for (int i = 0; i < word.toCharArray().length; i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                low++;
            } else {
                high++;
                if (i == 0) firstCapital = true;
            }
        }

        return low == 0 || high == 0 || (firstCapital && high == 1);
    }

    /**
     * regular expression:
     *
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
     */
}
