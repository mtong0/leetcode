package src.dp;
import java.util.LinkedList;
import java.util.Queue;

public class No799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int n = (query_row+3)*(query_row+2)/2;
        double[] cups = new double[n];
        Queue<Integer> layer = new LinkedList<>();
        Queue<Integer> nextLayer = new LinkedList<>();
        if (poured > 1) {
            layer.add(0);
        }
        cups[0] = poured;

        int index;

        int endOfCurrent = 0;
        int endOfNext = 0;
        int cur = 0;

        double left;

        while(!layer.isEmpty()) {
            index = layer.poll();
            cur++;
            left = cups[index]-1;
            if (endOfCurrent + cur + 1 >= n) break;
            if(cups[index] > 1) {
                cups[endOfCurrent+cur] += left/2;
                cups[endOfCurrent+cur+1] += left/2;
                cups[index] = 1;
                if(nextLayer.isEmpty())
                    nextLayer.add(endOfCurrent+cur);
                nextLayer.add(endOfCurrent+cur+1);
                endOfNext = endOfCurrent+cur+1;
            }
            if(layer.isEmpty()) {
                layer = new LinkedList<>(nextLayer);
                nextLayer.clear();
                endOfCurrent = endOfNext;
                cur = 0;
            }
        }

        int query = (1+query_row) * query_row / 2 + query_glass;
        return Math.min(1,cups[query]);
    }

    public static void main(String[] args) {
        double res = new No799().champagneTower(25, 6, 1);
        System.out.println(res);
    }
}
