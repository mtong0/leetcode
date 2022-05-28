import java.util.*;

public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<Integer> sortedNums = new ArrayList<>();
        for (int num: nums) {
            sortedNums.add(num);
        }
        sortedNums.sort(Comparator.comparingInt(a->a));

        Queue<Integer> lastIndexes = new LinkedList<>();
        Queue<List<Integer>> nextRounds = new LinkedList<>();

        ArrayList<Integer> l = new ArrayList<>();
        l.add(sortedNums.get(0));
        lastIndexes.add(0);
        nextRounds.add(l);

        int last = -11;
        for (int i = 1; i < n; i++) {
            if (!sortedNums.get(i).equals(nextRounds.peek().get(0))) {
                if (sortedNums.get(i) != last) {
                    l = new ArrayList<>();
                    l.add(sortedNums.get(i));
                    nextRounds.add(l);
                    lastIndexes.add(i);
                    last = sortedNums.get(i);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        int idx;
        Queue<List<Integer>> rounds = new LinkedList<>();
        while (!nextRounds.isEmpty()) {
            List<Integer> list = nextRounds.poll();
            res.add(list);
            idx = lastIndexes.poll();

            List<Integer> nextList = new ArrayList<>(list);

            last = -11;
            for (int i = idx + 1; i < n; i++) {
                int num = sortedNums.get(i);
                if (num != last) {
                    nextList.add(num);
                    lastIndexes.add(i);
                    rounds.add(new ArrayList<>(nextList));
                    last = num;
                    nextList.remove(nextList.size()-1);
                }
            }
            if (nextRounds.isEmpty()) {
                nextRounds = new LinkedList<>(rounds);
                rounds = new LinkedList<>();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        System.out.println(new Subset2().subsetsWithDup(nums));
    }
}
