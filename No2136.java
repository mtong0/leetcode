import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int currentDays = 0;
        int residualDays = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new MyComparator());
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{plantTime[i], growTime[i]});
        }
        while (!queue.isEmpty()) {
            int[] nextSeed = queue.poll();
            if (nextSeed[0] > residualDays) {
                currentDays = currentDays + (nextSeed[0] - residualDays) + nextSeed[1];
                residualDays = nextSeed[1];
            } else {
                residualDays = residualDays - nextSeed[0];
                if (nextSeed[1] > residualDays) {
                    currentDays += nextSeed[1] - residualDays;
                    residualDays = nextSeed[1];
                }
            }
        }
        return currentDays;
    }

    class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o2[1]-o1[1];
        }
    }

    public static void main(String[] args) {
        int[] plantTime = {1, 2, 3, 2};
        int[] growTime = {2, 1, 2, 1};
        int val = new No2136().earliestFullBloom(plantTime, growTime);
        System.out.println(val);
    }
}
