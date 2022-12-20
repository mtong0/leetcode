package src.algorithm.temp;

public class No1764 {
    class Pair {
        int index;
        boolean flag;

        public Pair(int index, boolean flag) {
            this.index = index;
            this.flag = flag;
        }
    }
    public boolean canChoose(int[][] groups, int[] nums) {
        Pair p = new Pair(0, false);
        for (int j = 0; j < groups.length;) {
            p = helper(groups[j], nums, p.index);
            if(p.index == -1) {
                return false;
            }
            if(p.flag) {
                j++;
            }
        }
        return true;
    }

    public Pair helper(int[] group, int[] nums, int n_i) {
        boolean start = false;
        for(;n_i < nums.length; n_i++) {
            if (group[0] == nums[n_i]) {
                start = true;
                break;
            }
        }
        int start_ni = n_i;
        if (start) {
            for(int i = 0; i < group.length; i++) {
                if (n_i == nums.length) {
                    return new Pair(-1, false);
                }
                if (group[i] != nums[n_i]) {
                    return new Pair(start_ni + 1, false);
                }
                n_i ++;
            }
        } else {
            return new Pair(-1, false);
        }
        return new Pair(n_i, true);
    }

    public static void main(String[] args) {

        int[][] groups = {{1,-1,-1}, {3,-2,0}};
        int[] nums = {1,-1,0,1,-1,-1,3,-2,0};
        System.out.println(new No1764().canChoose(groups, nums));
    }
}
