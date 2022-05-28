import java.util.HashSet;

public class BrokenCalculator {
    int count = Integer.MAX_VALUE;
    HashSet<Integer> visited = new HashSet<>();
    public int brokenCalc(int startValue, int target) {
        helper(startValue, target, 0);
        System.out.println(count);
        return count;
    }

    public void helper(int value, int target, int step) {
        if (visited.contains(value)) return;
        visited.add(value);
        if(value == target) {
            if(step < count) {
                count = step;
            }
        } else if (value > target) {
            if(step+value-target < count) {
                count = step+value-target;
            }
        } else {
            helper(value*2, target, step+1);
            helper(value-1, target, step+1);
        }
    }

    public static void main(String[] args) {
        int startValue = 56;
        int target = 123;
        new BrokenCalculator().brokenCalc(startValue, target);
    }
}
