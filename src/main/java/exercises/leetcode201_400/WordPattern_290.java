package exercises.leetcode201_400;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> dic = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (dic.containsKey(pattern.charAt(i))) {
                if (!words[i].equals(dic.get(pattern.charAt(i)))) return false;
            } else {
                if (dic.containsValue(words[i])) return false;
                dic.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }
}
