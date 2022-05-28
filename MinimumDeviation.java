import java.util.*;

public class MinimumDeviation {
    public int minimumDeviation(int[] nums) {
        int length = nums.length;
        LinkedList<Integer> sorted = new LinkedList<>();
        for (int num: nums) {
            sorted.add(num);
        }
        sorted.sort(Comparator.comparingInt(value -> value));
        int min = sorted.get(0);
        int max = sorted.get(length-1);
        int range = Integer.MAX_VALUE;
        int i = 0;
        int j = length - 1;
        int doubledMin;
        int halvedMax;
        boolean changed = true;
        do {
            range = max - min;
            //find min to see if it can be doubled
            if (min % 2 == 1) {
                doubledMin = sorted.get(0) * 2;
                while (sorted.get(++i) < doubledMin){
                    if (i == length) break;
                }
                sorted.remove(0);
                sorted.add(--i, doubledMin);
                i = 0;
            } else {
                if (max % 2 == 0) {
                    halvedMax = sorted.get(j) / 2;
                    while(halvedMax < sorted.get(--j)){
                        if (j == 0 ) break;
                    }
                    sorted.remove(length-1);
                    if (j == 0) {
                        sorted.addFirst(halvedMax);
                    } else {
                        sorted.add(++j, halvedMax);
                    }
                    j = length - 1;
                } else {
                    changed = false;
                }
            }
            min = sorted.get(0);
            max = sorted.get(j);
        } while (max - min <= range && changed);

        return range;
    }

    public static void main(String[] args) {
        int[] nums = {8,5,20,10,7,6};
        System.out.println(new MinimumDeviation().minimumDeviation(nums));
    }
}
