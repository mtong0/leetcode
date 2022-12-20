package src.algorithm.temp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> sortedInterval = new ArrayList<>(Arrays.asList(intervals));
        List<int[]> res = new ArrayList<>(sortedInterval);
        for (int i = sortedInterval.size()-1; i >= 0; i--) {
            for (int j = 0; j < res.size(); j++) {
                if (contains(res.get(j), sortedInterval.get(i))
                        && !(res.get(j)[0] == sortedInterval.get(i)[0] && res.get(j)[1] == sortedInterval.get(i)[1])) {
                    res.remove(i);
                    break;
                }
            }
        }
        return res.size();
    }
    //        sortedInterval.sort((a,b)->{
//            if (a[0]==b[0]) {
//                return b[1]-a[1];
//            } else {
//                return a[0]-b[0];
//            }
//        });
    public boolean contains(int[] interval1, int[] interval2) {
        return interval1[0] <= interval2[0] && interval1[1] >= interval2[1];
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,4},{3,6},{2,8},{1,2},{2,5},{0,4},{7,8}};
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(intervals));
    }
}
