import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class FindingPairsWithACertainSum {
    int[] nums2;
    HashMap<Integer, Integer> nums1Map;
    public FindingPairsWithACertainSum(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        nums1Map = new HashMap<>();
        for (int j : nums1) {
            if (nums1Map.containsKey(j)) {
                nums1Map.put(j, nums1Map.get(j) + 1);
            } else {
                nums1Map.put(j, 1);
            }
        }

    }

    public void add(int index, int val) {
        nums2[index] += val;
    }

    public int count(int tot) {
        int res = 0;
        for (int j : nums2) {
            if (nums1Map.containsKey(tot-j))
                res += nums1Map.get(tot - j);
        }
        return res;
    }
}
