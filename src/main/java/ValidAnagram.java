import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ruochen on 23/01/2017.
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
 */
public final class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        return sortString(s).equals(sortString(t));
    }
    
    public List<Character> sortString(String s) {
        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            charList.add(c);
        }
        Collections.sort(charList);
        return charList;
    }
}
