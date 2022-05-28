import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> sortedIntervals = new ArrayList<>(Arrays.asList(intervals));
        sortedIntervals.sort(Comparator.comparingInt(a -> a[0]));
        List<Integer> rooms = new ArrayList<>();
        rooms.add(0);
        for (int[] interval: sortedIntervals) {
            int i;
            for (i = 0; i < rooms.size(); i++) {
                if (interval[0] >= rooms.get(i)) {
                    rooms.set(i, interval[1]);
                    break;
                }
            }
            if (i == rooms.size()) {
                rooms.add(interval[1]);
            }
        }
        return rooms.size();
    }
}
