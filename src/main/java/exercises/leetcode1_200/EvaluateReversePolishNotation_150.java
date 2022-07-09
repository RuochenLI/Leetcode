package exercises.leetcode1_200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class EvaluateReversePolishNotation_150 {
    public static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> steak = new LinkedList<>();
        for (String token : tokens) {
            int number = OPERATORS.contains(token) ? calculate(steak, token) : Integer.parseInt(token);
            steak.push(number);
        }
        return steak.pop();
    }

    private int calculate(LinkedList<Integer> steak, String token) {
        int num2 = steak.pop();
        int num1 = steak.pop();
        if ("+".equals(token)) {
            return num1 + num2;
        }

        if ("-".equals(token)) {
            return num1 - num2;
        }

        if ("*".equals(token)) {
            return num1 * num2;
        }

        return num1 / num2;
    }
}
