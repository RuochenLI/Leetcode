package exercises.leetcode201_400;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber_246 {
    public boolean isStrobogrammatic0(String num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '2' || c == '3' || c == '4' || c == '5' || c == '7') {
                return false;
            }
            if (c == '6') {
                sb.append('9');
            } else if (c == '9') {
                sb.append('6');
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString().equals(s);
    }

    public boolean isStrobogrammatic(String num) {

        Map<Character, Character> rotatedDigits = new HashMap<>(Map.of('0',
                                                                       '0',
                                                                       '1',
                                                                       '1',
                                                                       '6',
                                                                       '9',
                                                                       '8',
                                                                       '8',
                                                                       '9',
                                                                       '6'));

        // Java allows us to have more than one iteration variable.
        for (int left = 0, right = num.length() - 1; left <= right; left++, right--) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if (!rotatedDigits.containsKey(leftChar) || rotatedDigits.get(leftChar) != rightChar) {
                return false;
            }
        }
        return true;

    }
}
