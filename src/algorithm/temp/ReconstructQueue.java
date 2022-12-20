package src.algorithm.temp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(people.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        queue.addAll(Arrays.asList(people));

        int[][] ans = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
