package challenge.year2020.may;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(final String num, final int k) {
        if (num.length() == k) {
            return "0";
        }
        int currentK = k;
        Stack<Character> characterStack = new Stack<>();
        for (int index = 0; index < num.length(); index++) {
            final Character c = num.charAt(index);
            while (currentK > 0 && !characterStack.empty() && characterStack.peek() > c) {
                characterStack.pop();
                --currentK;
            }
            characterStack.push(c);
        }
        while (currentK > 0) {
            characterStack.pop();
            --currentK;
        }
        final StringBuilder result = new StringBuilder();
        while (!characterStack.isEmpty()) {
            result.append(characterStack.pop());
        }
        result.reverse();
        if (result.length() == 1) {
            return result.toString();
        }
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public String removeKdigits2(String num, int k) {

        int length = num.length();
        if (length == k)  return "0";
        String result = findSmallest(num, num, length, 0, k);
        if (result.isEmpty()) return "0";
        return result;
    }

    private String findSmallest(final String minValue, final String num, final int length, final int pointer,
                               final int k) {
        if (k == 0) return compareString(minValue, num);

        if (pointer + k == length) {
            String result = num.substring(0, pointer);
            return compareString(minValue, result);
        }

        String result = compareString(minValue, findSmallest(minValue, num, length, pointer + 1, k));

        if (num.charAt(pointer) != '0') {
            StringBuilder currentBuilder = new StringBuilder();
            if (pointer != 0) currentBuilder.append(num, 0, pointer);
            currentBuilder.append(num, pointer + 1, length);
            String current = currentBuilder.toString();

            result = compareString(result, findSmallest(result, current, length - 1, pointer, k -1));
        }

        return result;
    }

    private String compareString(final String minValue, final String num) {
        String removeZero = removeZero(num);
        int removeZeroLength = removeZero.length();
        int minLength = minValue.length();
        if (removeZeroLength != minLength) {
            if (removeZeroLength < minLength) return removeZero;
            return minValue;
        }
        return minValue.compareTo(removeZero) > 0 ? removeZero : minValue;
    }

    private String removeZero(final String num) {
        int pointer = 0;
        while (pointer < num.length() && num.charAt(pointer) == '0') {
            pointer++;
        }
        return num.substring(pointer);
    }
}
