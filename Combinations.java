import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        boolean[] chose = new boolean[n];
        int[] nums = new int[n];
        for (int i = 1; i < n + 1; i++) {
            nums[i-1] = i;
        }
        res = new ArrayList<>();
        dfs(nums, chose, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, boolean[] chose, List<Integer> l) {
        if (l.size() < k) {
            int i;
            if (l.size() == 0) i = 0;
            else i = l.get(l.size()-1);
            for (; i < nums.length; i++) {
                if (!chose[i]) {
                    l.add(nums[i]);
                    chose[i] = true;
                    dfs(nums, chose, l);
                    chose[i] = false;
                    l.remove(l.size()-1);
                }
            }
        } else {
            List<Integer> ans = new ArrayList<>(l);
            res.add(ans);
        }
    }
}
