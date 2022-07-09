package exercises.leetcode1_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (true) {
            assert ans.peek() != null;
            if (ans.peek().length() == digits.length())
                break;
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }

    List<String> result;
    Map<Character, String> map;

    public List<String> letterCombinations1(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        build(0, "", digits);
        return result;
    }

    public void build(int index, String s, String digits) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }

        for (char c : map.get(digits.charAt(index)).toCharArray()) {
            build(index + 1, s + c, digits);
        }
    }
}
