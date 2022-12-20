package src.algorithm.dp;

public class No376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }

        int[] diffs = new int[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            diffs[i-1] = nums[i] - nums[i-1];
        }

        int count = 0;
        int prev;
        int cur;
        boolean flag = false;

        for (int i = 0; i < diffs.length - 1; i++) {
            prev = diffs[i];
            cur = diffs[i+1];
            if(prev == 0) continue;
            flag = true;
            if((cur > 0 && prev < 0) || (cur < 0 && prev > 0)) {
                count += 1;
            }
        }

        return flag?count+2:1;
    }
}
