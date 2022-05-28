public class SplitArrayLargestSum {
    int[][] subSums;
    int n;
    int res;
    public int splitArray(int[] nums, int m) {
        n = nums.length;
        subSums = new int[nums.length][nums.length];
        res = Integer.MAX_VALUE;
        System.arraycopy(nums, 0, subSums[0], 0, n);

        for(int i = 1; i < n; i++) {
            for(int j = i; j < n; j++) {
                subSums[i][j] = subSums[i-1][j-1] + nums[j];
            }
        }
        int max = helper(0, m-1);
        if (max < res) res = max;
        return res;
    }

    public int helper(int start, int mm) {
        int subSum = 0;
        int max = 0;
        for(int i = 0; start + i < n - mm; i++) {
            subSum = subSums[i][start+i];
            if(subSum > max) max = subSum;
            if (mm > 0) {
                max = Math.max(helper(start+i+1, mm-1), max);
                if (max < res) {
                    res = max;
                    max = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int m = 3;
        int res = new SplitArrayLargestSum().splitArray(nums, m);
        System.out.println(res);
    }
}
