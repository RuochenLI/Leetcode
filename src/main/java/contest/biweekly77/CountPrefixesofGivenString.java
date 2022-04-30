package contest.biweekly77;

import com.google.common.base.Strings;

public class CountPrefixesofGivenString {
    public int countPrefixes(String[] words, String s) {
        if (Strings.isNullOrEmpty(s)) {
            return 0;
        }
        int result = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                result++;
            }
        }
        return result;
    }
}
