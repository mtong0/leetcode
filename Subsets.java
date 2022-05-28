import java.util.ArrayList;
import java.util.List;

public class Subsets {
    int n;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        this.nums = nums;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            res.add(createSet(i));
        }
        return res;
    }

    public List<Integer> createSet(int bitmask) {
        List<Integer> sts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if((1<<i&bitmask) == (1<<i)) {
                sts.add(nums[i]);
            }
        }
        return sts;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new Subsets().subsets(nums);
    }
}
