package src.algorithm.temp;
import java.util.ArrayList;
import java.util.List;

public class JudgePoint24 {
    boolean res;
    List<Float> nums;
    public boolean judgePoint24(int[] cards) {
        nums = new ArrayList<>();
        for (int num: cards) {
            nums.add((float)num);
        }
        helper(nums);

        return res;
    }

    public void helper(List<Float> list) {
        if (list.size() == 1) {
            if (Math.abs(list.get(0)) - 24 < 0.001) res = true;
            return;
        }

        float num1;
        float num2;
        for (int i = 0; i < list.size(); i++) {
            num1 = list.get(i);
            list.remove(i);
            for (int j = 0; j < list.size(); j++) {
                num2 = list.get(j);
                list.remove(j);
                list.add(num1 + num2); helper(list); list.remove(list.size()-1);
                list.add(num1 - num2); helper(list); list.remove(list.size()-1);
                list.add(num1 * num2); helper(list); list.remove(list.size()-1);
                list.add(num1 / num2); helper(list); list.remove(list.size()-1);
                list.add(j,num2);
            }
            list.add(i, num1);
        }
    }



    public static void main(String[] args) {
        int[] card = {3,3,8,8};
        boolean ans = new JudgePoint24().judgePoint24(card);
        System.out.println(ans);
    }
}
