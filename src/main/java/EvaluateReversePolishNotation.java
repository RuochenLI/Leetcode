import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
valuate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
    
    public static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> expContextStack = new LinkedList<>();
        
        for (String exp : tokens) {
            if (!isOperator(exp)) {
                expContextStack.push(Integer.valueOf(exp));
            } else {
                expContextStack.push(calculate(expContextStack.pop(), expContextStack.pop(), exp));
            }
        }
        return expContextStack.pop();
    }
    
    private int calculate(int operand1, int operand2, String operator) {
        if (operator.equals("-")) {
            return operand2 - operand1;
        }

        if (operator.equals("+")) {
            return operand2 + operand1;
        }

        if (operator.equals("*")) {
            return operand2 * operand1;
        }

        if (operator.equals("/")) {
            return operand2 / operand1;
        }

        return -1;
    }

    private boolean isOperator(String s) {
        return OPERATORS.contains(s);
    }
}
