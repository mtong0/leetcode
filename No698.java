//import java.util.*;
//
//
//public class No698 {
//    NumMap numMap;
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//        numMap = new NumMap(nums);
//        List<Integer> numList = new ArrayList<>();
//        for (int num : nums) {
//            numList.add(num);
//        }
//        Collections.sort(numList);
//        int[] flags = new int[nums.length];
//    }
//
//    public void dp(List<Integer> nums, int[] flags, HashMap<Integer, String> visited, int leftK, int target, StringBuilder prev) {
//        int left = 0;
//        int right = 0;
//        int sum = nums.get(left);
//
//        int n;
//        int r;
//        while (sum != target) {
//            if(sum < target) {
//                n = nums.get(right);
//                r = numMap.getKeyRank(n);
//                sum += nums.get(right);
//                prev.setCharAt(r, String.valueOf(prev.charAt(r) + 1);
//            } else {
//                sum -= nums.get(left);
//            }
//        }
//
//    }
//
//    class NumMap {
//        TreeMap<Integer, Integer> numMap;
//        TreeMap<Integer, Integer> ranks;
//
//        int total;
//
//        NumMap(int[] nums) {
//            numMap = new TreeMap<>();
//            total = 0;
//            for (int n: nums) {
//                numMap.put(n, numMap.getOrDefault(n, 0));
//                total += n;
//            }
//            int i = 0;
//            for (int key: numMap.keySet()) {
//                ranks.put(key, i++);
//            }
//        }
//        int getKeyRank(int key) {
//            return ranks.get(key);
//        }
//    }
//}
