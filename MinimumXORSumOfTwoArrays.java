import java.util.*;

public class MinimumXORSumOfTwoArrays {
    int n;

    int[] nums1;
    int[] nums2;
    public int minimumXORSum(int[] nums1, int[] nums2) {
       int bitmask = 0;
       this.n = nums1.length;
       this.nums1 = nums1;
       this.nums2 = nums2;
       return dp(0,0);
    }

    public int dp(int i, int bitmask) {
        if (i == n) {
            return 0;
        }
        int ans= Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if ((bitmask&(1<<j)) == 0) {
                ans = Math.min(ans, nums1[i] ^ nums2[j] + dp(i+1, bitmask | (1<<j)));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2};
        int[] nums2 = new int[] {2,3};
        System.out.println(new MinimumXORSumOfTwoArrays().minimumXORSum(nums1, nums2));
    }
}
