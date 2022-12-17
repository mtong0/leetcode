import java.util.LinkedList;
import java.util.Stack;

public class No227 {
    class WrapInt {
        int value;
    }
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> operators = new Stack<>();

        WrapInt index = new WrapInt();

        int res = getNumber(s, index);
        nums.add(res);

        while(index.value < s.length()) {
            char c = getOperator(s, index);
            int num = getNumber(s, index);
            if(c == '*' || c == '/') {
                int prevVal = nums.pop();
                nums.add(cal(prevVal, num, c));
            } else {
                if (operators.size() != 0) {
                    char prevOp = operators.pop();
                    int prevVal2 = nums.pop();
                    int prevVal1 = nums.pop();
                    nums.add(cal(prevVal1, prevVal2, prevOp));
                }
                nums.add(num);
                operators.add(c);
            }
        }

        if (operators.size() > 0) {
            char op = operators.pop();
            int prevVal2 = nums.pop();
            int prevVal1 = nums.pop();
            return cal(prevVal1, prevVal2, op);
        } 
        return nums.peek();
    }

    public int getNumber(String s, WrapInt i) {
        int val = 0;
        for(; i.value < s.length(); i.value++) {
            if (s.charAt(i.value) >= '0' && s.charAt(i.value) <= '9') {
                val = val * 10 + s.charAt(i.value) - '0';
            } else if (s.charAt(i.value) != ' ') {
                return val;
            }
        }
        return val;
    }

    public char getOperator(String s, WrapInt i) {
        while(s.charAt(i.value) == ' ') {
            i.value++;
        }
        return s.charAt(i.value++);
    }

    public int cal(int val1, int val2, char op) {
        if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val1 - val2;
        } else if (op == '*') {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }
    public static void main(String[] args) {
        System.out.println(new No227().calculate("3+2*2"));
        
    }
}
