import java.util.*;

public class MaximumNumberofEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        LinkedList<int[]> sortedEvents = new LinkedList<>(Arrays.asList(events));
        sortedEvents.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] == o1[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int day = 1;
        int[] event;
        int count = 0;
        List<Integer> unsolvedDays = new ArrayList<>();
        for (int i = 0; i < sortedEvents.size(); i++) {
            for (int j = 0; j < unsolvedDays.size(); j++) {
                if (unsolvedDays.get(j) >= sortedEvents.get(i)[0] && unsolvedDays.get(j) <= sortedEvents.get(i)[1]) {
                    unsolvedDays.remove(j);
                    count += 1;
                    break;
                }
            }
            if (day < sortedEvents.get(i)[0]) {
                unsolvedDays.add(day);
            } else if (day >= sortedEvents.get(i)[0] && day <= sortedEvents.get(i)[1]) {
                count += 1;
            }
            day += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] events = {{1,2},{2,3},{3,4}};
        System.out.println(new MaximumNumberofEventsThatCanBeAttended().maxEvents(events));
    }
}
