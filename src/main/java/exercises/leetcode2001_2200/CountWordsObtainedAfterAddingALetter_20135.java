package exercises.leetcode2001_2200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2135. Count Words Obtained After Adding a Letter
 */
public class CountWordsObtainedAfterAddingALetter_20135 {
    public int wordCount(String[] startWords, String[] targetWords) {
        Map<Integer, Set<String>> startSet = new HashMap<>();
        int result = 0;

        for (String startWord : startWords) {
            char[] startWordCharArray = startWord.toCharArray();
            Arrays.sort(startWordCharArray);
            String sortedStartWord = String.valueOf(startWordCharArray);
            startSet.computeIfAbsent(sortedStartWord.length(), k -> new HashSet<>()).add(sortedStartWord);
        }

        for (String targetWord : targetWords) {
            if (startSet.containsKey(targetWord.length() - 1)) {
                Set<String> starts = startSet.get(targetWord.length() - 1);
                char[] targetCharArray = targetWord.toCharArray();
                Arrays.sort(targetCharArray);
                for (int j = 0; j < targetCharArray.length; j++) {
                    String sortedTarget = (j == 0 ? "" : String.copyValueOf(targetCharArray, 0, j)) +
                                          String.copyValueOf(targetCharArray, j + 1, targetCharArray.length - j - 1);
                    if (starts.contains(sortedTarget)) {
                        result++;
                        break;
                    }
                }

            }
        }

        return result;
    }
}
