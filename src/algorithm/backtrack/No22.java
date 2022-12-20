package src.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

public class No22 {
    int n;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        res = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0);
        return res;
    }

    private void backtrack(StringBuilder ans, int leftCount, int count) {
        if (ans.length() == 2 * n) {
            res.add(ans.toString());
        }
        if (count < n) {
            ans.append("(");
            backtrack(ans, leftCount + 1, count+1);
            ans.deleteCharAt(ans.length()-1);
        }

        if (leftCount > 0) {
            ans.append(')');
            backtrack(ans, leftCount-1, count);
            ans.deleteCharAt(ans.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new No22().generateParenthesis(3));
    }
}
