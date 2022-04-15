package exercises.leetcode1_200;

import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> steak = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c =='(') {
                steak.push(c);
            } else {
                if (steak.isEmpty()) return false;

                char popped = steak.pop();
                if (c == '}' && popped != '{') return false;

                if (c == ']' && popped != '[') return false;

                if (c == ')' && popped != '(') return false;
            }
        }
        return steak.isEmpty();
    }
}
