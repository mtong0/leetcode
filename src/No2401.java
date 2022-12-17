package src;

public class No2401 {
    public int longestNiceSubarray(int[] nums) {
        if (nums.length == 1) return 1;
        int max = 1;

        int left = 0, right = 1;
        int sum = nums[0];

        int length = 1;
        while(right < nums.length) {
            int num = nums[right];
            if ((num + sum) == (num ^ sum)) {
                sum += num;
                length += 1;
                max = Math.max(max, length);
                right += 1;
            } else {
                sum -= nums[left];
                length -= 1;
                left += 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,11,13};
        No2401 no2401 = new No2401();
        System.out.println(no2401.longestNiceSubarray(nums));
    }
}
