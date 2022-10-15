package exercises.leetcode601_800;

import java.util.Set;
import java.util.Stack;

/**
 * 772. Basic Calculator III
 */
public class BasicCalculatorIII_772 {
    private final static Set<Character> OPERATOR_SET = Set.of('+', '-', '*', '/');

    public int calculate(String s) {
        final Stack<Integer> operandStack = new Stack<>();
        final Stack<Character> operatorStack = new Stack<>();
        final int length = s.length();
        int operand = 0;
        for (int pt = 0; pt < length; pt++) {
            char currentChar = s.charAt(pt);
            if (Character.isDigit(currentChar)) {
                operand = currentChar - '0';
                while (pt < length - 1 && Character.isDigit(s.charAt(pt + 1))) {
                    pt++;
                    operand = operand * 10 + (s.charAt(pt) - '0');
                }
                operandStack.push(operand);
            } else {
                if (currentChar == ' ') {
                    continue;
                }

                if (currentChar == '(') {
                    operatorStack.push('(');
                    continue;
                }

                if (currentChar == ')') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                        operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                    }
                    operatorStack.pop();
                    continue;
                }

                if (OPERATOR_SET.contains(currentChar)) {
                    while (!operatorStack.isEmpty() && precedence(currentChar, operatorStack.peek())) {
                        operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                    }
                    operatorStack.push(currentChar);
                }
            }
        }
        while (!operatorStack.empty()) {
            operandStack.push(calculate(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
        }
        return operandStack.pop();
    }

    private boolean precedence(final char currentOperator, final Character prevOperator) {
        if (prevOperator == '(' || prevOperator == ')') {
            return false;
        }

        if ((currentOperator == '*' || currentOperator == '/') && (prevOperator == '+' || prevOperator == '-')) {
            return false;
        }

        return true;
    }

    private int calculate(final Character operator, final Integer operand2, final Integer operand1) {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> 0;
        };
    }
}
