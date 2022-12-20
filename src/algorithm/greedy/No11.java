package src.algorithm.greedy;

import java.util.HashMap;

public class No11 {
    int left = Integer.MAX_VALUE;
    int right = Integer.MIN_VALUE;

    HashMap<Integer, Pair> map = new HashMap<>();
    public int maxArea(int[] height) {
        int area = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            Pair pair = map.getOrDefault(height[i], new Pair(i, i));
            pair.l = Math.min(pair.l, i);
            pair.r = Math.max(pair.r, i);
            map.put(height[i], pair);
            max = Math.max(max, height[i]);
        }

        for (int i = max; i >= 0; i--) {
            Pair pair = map.get(i);
            if (pair != null) {
                left = Math.min(left, pair.l);
                right = Math.max(right, pair.r);
                area = Math.max(area, i * (right - left));
            }
        }
        return area;
    }

    private static class Pair {
        int l;
        int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        new No11().maxArea(height);
    }
}
