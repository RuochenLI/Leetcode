package exercises.leetcode1201_1400;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SmallestStringWithSwaps_1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        String smallest = s;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            visited.add(current);

            for (List<Integer> pair : pairs) {
                if (current.charAt(pair.get(0)) != current.charAt(pair.get(1))) {
                    char[] chars = current.toCharArray();
                    char tmp = chars[pair.get(0)];
                    chars[pair.get(0)] = chars[pair.get(1)];
                    chars[pair.get(1)] = tmp;
                    String newStr = String.valueOf(chars);
                    if (!visited.contains(newStr) && !queue.contains(newStr)) {
                        queue.offer(newStr);
                        if (newStr.compareTo(smallest) < 0) {
                            smallest = newStr;
                        }
                    }
                }
            }
        }
        return smallest;
    }
}
