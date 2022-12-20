package src.greedy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No881 {
    public int numRescueBoats(int[] people, int limit) {
        List<Integer> ps = new ArrayList<>();
        for(int p: people) {
            ps.add(p);
        }
        ps.sort(Comparator.comparingInt(x->x));

        int left = 0;
        int right = people.length - 1;

        int count = 0;
        while (left < right) {
            if (ps.get(right) + ps.get(left) > limit) {
                right -= 1;
            } else {
                left += 1;
                right -= 1;
            }
            count += 1;
        }
        if (left == right) {
            count += 1;
        }
        return count;
    }
}
