package exercises.leetcode201_400;

import java.util.ArrayList;
import java.util.List;

public class FlipGame293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String tmp = String.valueOf(sb) + '-' + '-' + s.substring(i + 2);
                result.add(tmp);
            }
            sb.append(s.charAt(i));
        }
        return result;
    }
}
