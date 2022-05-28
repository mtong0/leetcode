import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num: nums) {
            if (numbers.contains(num)) {
                numbers.remove(num);
            } else {
                numbers.add(num);
            }
        }
        return new ArrayList<Integer>(numbers).get(0);
    }
}
