public class No416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums) {
            sum += n;
        }
        if (sum % 2 == 1) return false;
        int half = sum / 2;
        int[][] dp = new int[nums.length][half];
        for(int i = 0; i < half; i++) {
//            for (int i)
        }
        return true;
    }
}
