import java.util.Arrays;

public class SortColor {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        int p0;
        int p2;
        while (l < nums.length && nums[l] == 0) l++;
        while (r >= 0 && nums[r] == 2) r--;


        p0 = l;
        p2 = r;
        while (l <= r) {
            if (nums[l] == 2) {
                swap(nums, l, p2);
            }
            if (nums[l] == 0) {
                swap(nums, p0, l);
            }
            l++;
            while (p0 < nums.length && nums[p0] == 0) {
                p0++;
            }
            while (p2 > -1 &&nums[p2] == 2) {
                p2--;
            }
            l = Math.max(p0, l);
            r = Math.min(p2, r);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,0,2,1,0,2,1,2,2,0,0,0,1,2};
        new SortColor().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
