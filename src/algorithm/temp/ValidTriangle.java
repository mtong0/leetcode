package src.algorithm.temp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ValidTriangle {
    public int triangleNumber(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            l.add(nums[i]);
        }

        l.sort(Comparator.comparingInt(value -> value));
        return 0;
    }
}
