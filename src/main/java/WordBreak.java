/**
 * Created by Ruochen on 23/01/2017.
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
public final class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < charArray.length; index++) {
            sb.append(charArray[index]);
            if (wordDict.contains(sb.toString())) {
                if (wordBreak(s.substring(index + 1), wordDict)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
