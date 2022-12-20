package src.algorithm.temp;
import java.util.ArrayList;
import java.util.List;

public class No376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        List<Integer> nextIter = new ArrayList<>();
        int[] nextIterArr;

        int prev = nums[0];
        int cur = 0;
        int prevDiff = 0;
        int curDiff = 0;
        
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i];
            curDiff =  cur - prev;
            while (curDiff == 0 || (curDiff < 0 && prevDiff < 0) || (curDiff > 0 && prevDiff > 0)) {
                nextIter.add(cur);

                if (i == nums.length - 1) {
                    nextIterArr = nextIter.stream().mapToInt(num->num).toArray();
                    return Math.max(count + 1, wiggleMaxLength(nextIterArr));
                }
                i++;
                cur = nums[i];
                curDiff = cur - prev;
            }
            count += 1;
            prevDiff = curDiff;
            prev = cur;
        }

        nextIterArr = nextIter.stream().mapToInt(num->num).toArray();
        return Math.max(count + 1, wiggleMaxLength(nextIterArr));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(new No376().wiggleMaxLength(nums));
    }
}
