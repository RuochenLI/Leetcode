package exercises.leetcode201_400;

public class DecodeString_394 {
    public String decodeString(String s) {
        int pointer = 0;
        StringBuilder result = new StringBuilder();
        while (pointer < s.length()) {
            char c = s.charAt(pointer);
            if (c <= 'z' && c >= 'a') {
                result.append(c);
                pointer++;
            } else {
                String repeat = getRepeatTimes(s, pointer, c);
                int repeatTimes = Integer.parseInt(repeat);
                pointer = pointer + repeat.length();
                int start = pointer + 1;
                int innerPointer = start + 1;
                int count = 1;
                while (innerPointer < s.length() && count > 0) {
                    if (s.charAt(innerPointer) == '[') count++;
                    if (s.charAt(innerPointer) == ']') count--;
                    innerPointer++;
                }
                pointer = innerPointer;
                int end = innerPointer - 1;
                String repeatString = decodeString(s.substring(start, end));
                for (int i = 0; i < repeatTimes; i++) {
                    result.append(repeatString);
                }
            }
        }
        return result.toString();
    }

    private String getRepeatTimes(String s, int pointer, char c) {
        StringBuilder repeater = new StringBuilder();
        while (s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9') {
            repeater.append(s.charAt(pointer));
            pointer++;
        }
        return repeater.toString();
    }

    /**
     * public class Solution {

    public String expressionExpand(String s) {
     *Stack<Object> stack = new Stack<>();
     *int number = 0;
     *
     *for (char c : s.toCharArray()) {
     *if (Character.isDigit(c)) {
     *number = number * 10 + c - '0';
     *} else if (c == '[') {
     *stack.push(Integer.valueOf(number));
     *number = 0;
     *} else if (c == ']') {
     *String newStr = popStack(stack);
     *Integer count = (Integer) stack.pop();
     *for (int i = 0; i < count; i++) {
     *stack.push(newStr);
     *}
     *} else {
     *stack.push(String.valueOf(c));
     *}
     *}
     *
     *return popStack(stack);
     *}
     *
             *

    private String popStack(Stack<Object> stack) {
     *         // pop stack until get a number or empty
     *Stack<String> buffer = new Stack<>();
     *while (!stack.isEmpty() && (stack.peek() instanceof String)) {
     *buffer.push((String) stack.pop());
     *}
     *
     *StringBuilder sb = new StringBuilder();
     *while (!buffer.isEmpty()) {
     *sb.append(buffer.pop());
     *}
     *return sb.toString();
     *}
     *
}
     */
}
