import java.util.HashMap;

public class No2244 {
    public int minimumRounds(int[] tasks) {
        int[] countArr = new int[10001];
        resolve(countArr);
        HashMap<Integer, Integer> taskMap = new HashMap<>();
        for(int t: tasks) {
            taskMap.put(t, taskMap.getOrDefault(t, 0)+1);
        }

        int count = 0;
        for(int key: taskMap.keySet()) {
            count += countArr[taskMap.get(key)];
        }
        return count;
    }

    public void resolve(int[] countArr) {
        countArr[1] = -1;
        countArr[2] = 1;
        countArr[3] = 1;
        countArr[4] = 2;
        for(int i = 5; i < 10001; i++) {
            countArr[i] = Math.min(countArr[i-2]+1, countArr[i-3]+1);
        }
    }
}
