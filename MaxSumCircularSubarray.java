public class MaxSumCircularSubarray {
    int n;
    public int maxSubarraySumCircular(int[] nums) {
        n = nums.length;
        int max = Integer.MIN_VALUE;

        int i = 0;

        int start;
        while (i<n) {
            start = nums[i];
            if (start > max) max = start;
            if (start < 0) {
                i++;
                continue;
            }
            int nextI = -1;
            int j;
            for (j = getIndex(i); j != i; j=getIndex(j)) {
                if (nextI == -1 && nums[j] <= 0) {
                    nextI = j;
                }
                start += nums[j];
                if (start < 0) break;
                if (start > max) max = start;
            }
            if (j == i && nextI == -1) {
                break;
            }
            nextI = nextI == -1?i+1:nextI;
            if (nextI < i) {
                break;
            } else i = nextI;
        }
        return max;
    }

    public int getIndex(int i) {
        if (i+1 < n) {
            return i + 1;
        } else {
            return (i+1)%n;
        }
    }
    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        int res = new MaxSumCircularSubarray().maxSubarraySumCircular(nums);
        System.out.println(res);
    }
}
