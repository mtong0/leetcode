package src.algorithm.temp;
import java.util.Stack;

public class LongestValidParentheses {
    int left = 0;
    int currentLength = 0;
    int max = 0;
    Stack<Character> l = new Stack<>();
    public int longestValidParentheses(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left == 0 && c == ')') l.clear();
            if (c == '(') {
                l.push(c);
                left += 1;
            }
            if (left > 0 && c == ')') {
                left -= 1;
                currentLength += 2;
                if (currentLength > max) {
                    max = currentLength;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
    }
}
