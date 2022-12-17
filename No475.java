import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No475 {
    public int findRadius(int[] houses, int[] heaters) {
        List<Integer> heaterList = new ArrayList<>();
        for (int i = 0 ; i < heaters.length; i++) {
            heaterList.add(heaters[i]);
        }
        int minR = Integer.MIN_VALUE;

        for (int i = 0; i < houses.length; i++) {
            minR = Math.max(minR, binSearch(houses[i], heaterList, 0, heaters.length-1));
        }
        return minR;
    }

    int binSearch(int house, List<Integer> heaters, int i, int j) {
        if (i == j) {
            return Math.abs(house-heaters.get(i));
        }
        if (i + 1 == j) {
            int leftH = heaters.get(i);
            int rightH = heaters.get(j);
            return Math.min(Math.abs(house-leftH), Math.abs(rightH-house));
        } else {
            int mid = (i + j)/2;
            int heat = heaters.get(mid);
            if (heat < house) {
                return binSearch(house, heaters, mid, j);
            } else {
                return binSearch(house, heaters, i, mid);
            }
        }
    }
}
