package exercises.leetcode201_400;

import java.util.Stack;

/**
 * 227. Basic Calculator II
 */
public class BasicCalculatorII_227 {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        int operand = 0;
        int result = 0;
        int prevOperand = 0;
        char operator = '+';
        for (int pt = 0; pt < length; pt++) {
            char currentChar = s.charAt(pt);
            if (Character.isDigit(currentChar)) {
                operand = currentChar - '0';
                while (pt < length - 1 && Character.isDigit(s.charAt(pt + 1))) {
                    pt++;
                    operand = operand * 10 + (s.charAt(pt) - '0');
                }
            } else {
                if (currentChar == ' ') {
                    continue;
                }
                if (precedence(operator, currentChar)) {
                    prevOperand = calculate(operator, prevOperand, operand);
                } else {
                    result += prevOperand;
                    prevOperand = operator == '+' ? operand : -operand;
                }
                operator = currentChar;
            }
        }
        return result + calculate(operator, prevOperand, operand);
    }

    private boolean precedence(final char preOperator, final char currentOperator) {
        return (currentOperator != '*' && currentOperator != '/') || (preOperator != '+' && preOperator != '-');
    }

    private int calculate(final Character operator, final Integer operand1, final Integer operand2) {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> 0;
        };
    }


    // stack
    public int calculate0(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // without stack
    public int calculate1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}
