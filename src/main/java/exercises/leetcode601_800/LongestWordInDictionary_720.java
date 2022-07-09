package exercises.leetcode601_800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestWordInDictionary_720 {
    public String longestWord(String[] words) {
        Map<String, List<String>> trie = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() != b.length() ? a.length() - b.length() : a.compareTo(b));
        int max = 0;
        String result = "";

        for (String word : words) {
            if (word.length() == 1 || trie.containsKey(word.substring(0, word.length() - 1))) {
                trie.put(word, new ArrayList<>());
                if (word.length() > 1) {
                    trie.get(word.substring(0, word.length() - 1)).add(word);
                }
                if (word.length() > max) {
                    result = word;
                    max = word.length();
                }
            }
        }
        return result;
    }

    public String longestWord1(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
}
