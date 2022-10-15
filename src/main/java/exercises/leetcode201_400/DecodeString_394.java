package exercises.leetcode201_400;

public class DecodeString_394 {
    public String decodeString2021(String s) {
        int pointer = 0;
        StringBuilder result = new StringBuilder();
        while (pointer < s.length()) {
            char c = s.charAt(pointer);
            if (c <= 'z' && c >= 'a') {
                result.append(c);
                pointer++;
            } else {
                String repeat = getRepeatTimes(s, pointer);
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
                String repeatString = decodeString2021(s.substring(start, end));
                result.append(String.valueOf(repeatString).repeat(Math.max(0, repeatTimes)));
            }
        }
        return result.toString();
    }

    private String getRepeatTimes(String s, int pointer) {
        StringBuilder repeater = new StringBuilder();
        while (s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9') {
            repeater.append(s.charAt(pointer));
            pointer++;
        }
        return repeater.toString();
    }
}
