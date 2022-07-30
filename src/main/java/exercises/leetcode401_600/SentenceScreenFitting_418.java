package exercises.leetcode401_600;

/**
 * 418. Sentence Screen Fitting
 */
public class SentenceScreenFitting_418 {
    public int wordsTyping0(String[] sentence, int rows, int cols) {
        int ptCol = 0;
        int ptRow = 0;
        int ptSentence = 0;
        int count = 0;
        while (ptRow < rows) {
            while (sentence[ptSentence].length() <= cols - ptCol) {
                ptCol += sentence[ptSentence].length();
                ptCol++;
                ptSentence++;
                if (ptSentence >= sentence.length) {
                    ptSentence = 0;
                    count++;
                }
            }
            ptRow++;
            ptCol = 0;
            if (ptSentence == 0) {
                count = count * (rows / ptRow);
                ptRow = ptRow * (rows / ptRow);
            }
        }
        return count;
    }

    /**
     * String s = String.join(" ", sentence) + " " ;. This line gives us a formatted sentence to be put to our screen.
     * start is the counter for how many valid characters from s have been put to our screen.
     * if (s.charAt(start % l) == ' ') is the situation that we don't need an extra space for current row. The current row could be successfully fitted. So that we need to increase our counter by using start++.
     * The else is the situation, which the next word can't fit to current row. So that we need to remove extra characters from next word.
     * start / s.length() is (# of valid characters) / our formatted sentence.
     */
    public int wordsTyping1(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }

    /**
     * dp
     * Based on the above observation, in the first for loop we compute the number of words that can be placed in the row if ith word is used as the starting word. This is saved as dp[i]. Note that this value can be greater than n.
     * In the next for loop we calculate how many words are placed in each row based on dp[i]. Imagine placing the 0th word in the row-0, then this row will hold dp[0] words. Next, which word will be placed on the start of next row? We calculate that using dp[k] % n (Remember dp[i] can be greater than n).
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int length = 0, words = 0, index = i;
            while (length + sentence[index % n].length() <= cols) {
                length += sentence[index % n].length();
                length += 1; // space
                index++;
                words++;
            }
            dp[i] = words;
        }

        int words = 0;
        for (int i = 0, index = 0; i < rows; i++) {
            words += dp[index];
            index = (dp[index] + index) % n;
        }

        return words / n;
    }
}
