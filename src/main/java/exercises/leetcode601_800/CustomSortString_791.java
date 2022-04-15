package exercises.leetcode601_800;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CustomSortString_791 {
    public String customSortString(String order, String s) {
        int[] charCount = new int[26];
        for(char c : s.toCharArray()){
            charCount[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        //first store char in same order of String X
        for(char c : order.toCharArray()){
            while(charCount[c - 'a'] --> 0){
                sb.append(c);
            }
        }

        //now store remaining char of string Y
        for(int i = 0; i < 26; i++){
            char c = (char)('a' + i);
            while(charCount[i] --> 0){
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String customSortString1(String order, String s) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.toCharArray().length; i++) {
            orderMap.put(order.charAt(i), i);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.comparingInt(a -> orderMap.getOrDefault(a, 0)));
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            result.append(queue.poll());
        }
        return result.toString();
    }
}
