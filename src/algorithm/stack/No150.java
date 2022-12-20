package src.algorithm.stack;

import java.util.Stack;

public class No150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<String> s = new Stack<>();
        for (String t: tokens) {
            s.add(t);
        }
        int res = eval(s);
        return res;
    }

    public int eval(Stack<String> tokens) {
        String operator = tokens.pop();
        int value1;
        int value2;
        if (tokens.peek().equals("+") || tokens.peek().equals("-") || tokens.peek().equals("*") || tokens.peek().equals("/")) {
            value1 = eval(tokens);
        } else {
            value1 = Integer.parseInt(tokens.pop());
        }

        if (tokens.peek().equals("+") || tokens.peek().equals("-") || tokens.peek().equals("*") || tokens.peek().equals("/")) {
            value2 = eval(tokens);
        } else {
            value2 = Integer.parseInt(tokens.pop());
        }

        if (operator.equals("+")) {
            return value2 + value1;
        } else if (operator.equals("-")) {
            return value2 - value1;
        } else if (operator.equals("*")) {
            return value2 * value1;
        } else {
            return value2 / value1;
        }
    }
    public static void main(String[] args) {
        return;
    }
}
