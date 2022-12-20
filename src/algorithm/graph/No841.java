package src.algorithm.graph;

import java.util.LinkedList;
import java.util.List;

public class No841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];

        int count = 1;
        LinkedList<Integer> nextRooms = new LinkedList<>();
        nextRooms.addAll(rooms.get(0));
        while (!nextRooms.isEmpty()) {
            int key = nextRooms.poll();
            if (!visit[key]) {
                visit[key] = true;
                count += 1;
                
            }
            for (int k: rooms.get(key)) {
                if (!visit[key]) {
                    nextRooms.add(k);
                }
            }
        }
        return count == n;
    }
}
