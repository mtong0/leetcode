//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//
//public class No473 {
//    public boolean makesquare(int[] matchsticks) {
//        HashMap<Integer, Integer> sticksMap = new HashMap<>();
//        int total = 0;
//        for(int s: matchsticks) {
//            total += s;
//            sticksMap.put(s, sticksMap.get(s) + 1);
//        }
//
//        if (total % 4 != 0) {
//            return false;
//        }
//
//        List<Integer> sticks = new ArrayList<>(sticksMap.keySet());
//        Collections.sort(sticks);
//        List<Integer> countSticks = new ArrayList<>();
//        for (int s: sticks) {
//            countSticks.add(sticksMap.get(s));
//        }
//
//        String mask = "0".repeat(sticks.size());
//
//
//    }
//
//    public void dp(String mask, int sideCount, int[] matchSticks) {
//
//    }
//}
