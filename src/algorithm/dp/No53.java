package src.algorithm.dp;

public class No53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n+1];
        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            sum += nums[i-1];
            sums[i] = sum;
        }

        int max = -10001;
        int min = 10001;

        int res = sums[1];

        for (int i = 0; i < n+1; i++) {
            if (sums[i] > max) {
                max = sums[i];
                res = Math.max(res, max - min);

            }
            if (sums[i] < min) {
                min = sums[i];
                max = min;
            }
            if (i < n) {
                res = Math.max(res, nums[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
        No53 no53 = new No53();
        System.out.println(no53.maxSubArray(nums));
    }
}
