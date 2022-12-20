package src.dp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class No740 {
    /* Solution 1
    private HashMap<Integer, Integer> points = new HashMap<>();
    private HashMap<Integer, Integer> caches = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(num, maxNumber);
        }

        return maxPoint(maxNumber);
    }

    public int maxPoint(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return points.getOrDefault(1, 0);
        }
        if (caches.containsKey(num)) {
            return caches.get(num);
        }

        int gain = points.getOrDefault(num, 0);
        caches.put(num, Math.max(maxPoint(num-1),maxPoint(num-2)+gain));
        return caches.get(num);
    }
*/
    /* solution 2
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(num, maxNumber);
        }

        int[] maxPoints = new int[maxNumber+1];
        maxPoints[1] = points.getOrDefault(1, 0);

        for (int i = 2; i < maxPoints.length; i++) {
            int gain = points.getOrDefault(i, 0);
            maxPoints[i] = Math.max(maxPoints[i-2] + gain, maxPoints[i-1]);
        }

        return maxPoints[maxNumber];
    }
*/
    /* Solution 3
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(num, maxNumber);
        }

        int oneBack = 0;
        int twoBack = points.getOrDefault(1, 0);

        int cur = oneBack;
        for (int i = 2; i < maxNumber+1; i++) {
            int gain = points.getOrDefault(i, 0);
            cur = Math.max(twoBack + gain, oneBack);
            twoBack = oneBack;
            oneBack = cur;
        }

        return cur;
    }
*/
   /* Solution 4
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(num, maxNumber);
        }
        List<Integer> elements = new ArrayList<>(points.keySet());
        Collections.sort(elements);

        int twoBack = 0;
        int oneBack = points.get(elements.get(0));
        int curEle;
        int curVal = oneBack;
        int prev = 0;
        for (int i = 1; i < elements.size(); i++) {
            curEle = elements.get(i);
            if (curEle - 1 == prev) {
                curVal = Math.max(twoBack + points.get(curEle), oneBack);
            } else {
                curVal = oneBack + points.get(curEle);
            }
            twoBack = oneBack;
            oneBack = curVal;
            prev = i;
        }
        return curVal;
    }
    */
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(num, maxNumber);
        }
        int n = nums.length;

        int oneBack = points.getOrDefault(1, 0);
        int twoBack = 0;
        int cur = oneBack;
        if (maxNumber < Math.log(n) * n) {
            for (int i = 2; i < maxNumber + 1; i++) {
                cur = Math.max(twoBack + points.get(i), oneBack);
                oneBack = cur;
                twoBack = oneBack;
            }
        } else {
            List<Integer> elements = new ArrayList<>(points.keySet());
            Collections.sort(elements);
            oneBack = points.get(elements.get(0));
            for (int i = 1; i < elements.size(); i++) {
                if (elements.get(i) - 1 == elements.get(i-1)) {
                    cur = Math.max(points.get(elements.get(i)) + twoBack, oneBack);
                } else {
                    cur = oneBack + points.get(elements.get(i));
                }
                oneBack = cur;
                twoBack = oneBack;
            }
        }
        return cur;
    }
    public static void main(String[] args) {
        int[] nums = {3,3,2,4,4,6,7,8,9,9,6};
        int res = new No740().deleteAndEarn(nums);
        System.out.println(res);
    }
}
