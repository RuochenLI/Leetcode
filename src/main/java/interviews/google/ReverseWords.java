package interviews.google;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder resultBuilder = new StringBuilder();
        Deque<Character> charQueue = new LinkedList<>();
        Stack<String> wordStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                charQueue.offer(c);
            } else {
                if (charQueue.isEmpty()) continue;

                StringBuilder wordBuilder = new StringBuilder();
                while (!charQueue.isEmpty()) {
                    wordBuilder.append(charQueue.pollFirst());
                }
                wordStack.push(wordBuilder.toString());
                wordStack.push(String.valueOf(c));
            }
        }
        StringBuilder wordBuilder = new StringBuilder();
        while (!charQueue.isEmpty()) {
            wordBuilder.append(charQueue.pollFirst());
        }
        wordStack.push(wordBuilder.toString());

        while (!wordStack.isEmpty()) {
            String word = wordStack.pop();
            if (resultBuilder.length() == 0 && word.equals(" "))  continue;

            resultBuilder.append(word);
        }
        return resultBuilder.toString();
    }
}
