import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LongestHappyString {

    class MyChar implements Comparable{
        char c;
        int freq;

        public MyChar(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(Object o) {
            return ((MyChar)o).freq - freq;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<MyChar> pq = new PriorityQueue<>();
        if (a > 0) {
            pq.add(new MyChar('a', a));
        }
        if (b > 0) {
            pq.add(new MyChar('b', b));
        }
        if (c > 0) {
            pq.add(new MyChar('c', c));
        }
        MyChar c1;
        MyChar c2;
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                c1 = pq.poll();
                int k = Math.max(2, c1.freq);
                for (int i = 0; i < k; i++) {
                    res.append(c1.c);
                }
                break;
            }
            c1 = pq.poll();
            c2 = pq.poll();
            int k = Math.min(1 + c1.freq - c2.freq, 2);
            for (int i = 0; i < k; i++) {
                res.append(c1.c);
                c1.freq -= 1;
            }
            res.append(c2.c);
            c2.freq -= 1;
            if (c1.freq > 0) pq.add(c1);
            if (c2.freq > 0) pq.add(c2);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 7;
        new LongestHappyString().longestDiverseString(a, b, c);
    }
}
