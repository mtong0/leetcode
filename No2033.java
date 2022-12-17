import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class No2033 {
    List<Integer> nums = new ArrayList<>();
    public int minOperations(int[][] grid, int x) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                nums.add(grid[i][j]);
            } 
        }

        Collections.sort(nums);

        int left = 1;
        int leftNum = nums.get(0);
        int right = 1;
        int rightNum = nums.get(nums.size()-1);
        
        
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        new No2033().minOperations(grid, 1);
    }
}