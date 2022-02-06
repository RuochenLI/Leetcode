package context.biweekly66;

import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Boolean> count1 = new HashMap<>();
        HashMap<String, Boolean> count2 = new HashMap<>();
        int ans = 0;
        for (String word : words1) {
            if (count1.containsKey(word)) {
                count1.remove(word);
                count1.put(word, false);
            } else {
                count1.put(word, true);
            }
        }

        for (String word : words2) {
            if (count2.containsKey(word)) {
                count2.remove(word);
                count2.put(word, false);
            } else {
                count2.put(word, true);
            }
        }

        for (Map.Entry<String, Boolean> entry : count1.entrySet()) {
            if (entry.getValue()) {
                if (count2.containsKey(entry.getKey()) && count2.get(entry.getKey())) ans++;
            }
        }
        return ans;
    }
}
