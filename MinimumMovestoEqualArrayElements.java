import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumMovestoEqualArrayElements {
    int min = Integer.MAX_VALUE;
    public int minMoves(int[] nums) {
        for (int num: nums) {
            if (num < min) min = num;
        }
        int count = 0;
        for (int num: nums) {
            count += (num-min);
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new MinimumMovestoEqualArrayElements().minMoves(nums);
    }
}
