package exercises.leetcode201_400;

import java.util.LinkedList;

import com.google.common.base.Strings;

/**
 * 388. Longest Absolute File Path
 */
public class LongestAbsoluteFilePath_388 {
    public int lengthLongestPath(String input) {
        String[] rows = input.split("\n");
        LinkedList<String> stack = new LinkedList<>();
        String result = "";
        for (String row : rows) {
            int level = 0;
            int pt = 0;
            while (pt < row.length() - 1 && "\t".equals(row.substring(pt, pt + 1))) {
                level++;
                pt += 1;
            }
            String name = row.substring(pt);
            while (!stack.isEmpty() && stack.size() > level) {
                stack.pop();
            }
            stack.push(name);
            if (name.contains(".")) {
                String current = String.join("/", stack);
                if (current.length() > result.length()) {
                    result = current;
                }
            }
        }
        return result.length();
    }
}
