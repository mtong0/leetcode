package src;

import java.util.ArrayList;
import java.util.HashMap;

public class No446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        ArrayList<HashMap<Integer, Integer>> records = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            records.add(new HashMap<>());
            HashMap<Integer, Integer> idxMap = records.get(i);
            for (int j = 0; j <= i; j++) {
                int diff = nums[i] - nums[j];
                HashMap<Integer, Integer> subIdxMap = records.get(j);
                if (subIdxMap.containsKey(diff) && subIdxMap != idxMap) {
                    idxMap.put(diff, subIdxMap.get(diff) + 1);
                    subIdxMap.remove(diff);
                } else if(!subIdxMap.containsKey(diff)) {
                    int val = idxMap.getOrDefault(diff, 1);
                    if (diff > 0) {
                        idxMap.put(diff, val + 1);
                    }
                }
            }
        }

        ArrayList<Integer> counts = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> record = records.get(i);
            for (int key: record.keySet()) {
                if (record.get(key) >= 3) {
                    if (key == 0) {
                        int number = record.get(key);
                        for(int j = number; j >= 3; j--) {
                            res += fact(number, j);
                        }
                    } else {
                        counts.add(record.get(key));
                    }
                }
            }
        }

        for (int c: counts) {
            res += ((c-1) * (c-2) / 2);
        }

        return res;
    }

    public int fact(int n, int count) {
        int res = 1;
        int num = n;
        for (int i = 0; i < count; i++) {
            res = res * num;
            num --;
        }

        int div = 1;
        for (int i = count; i > 1; i--) {
            div = div * i;
        }
        return res / div;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        No446 no446 = new No446();
//        System.out.println(no446.fact(5, 3));
        System.out.println(no446.numberOfArithmeticSlices(nums));
    }
}
