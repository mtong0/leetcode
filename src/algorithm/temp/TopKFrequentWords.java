package src.algorithm.temp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> stringMap = new HashMap<>();
        for (String s: words) {
            stringMap.put(s, stringMap.getOrDefault(s, 0) + 1);
        }

        List<String> sortedStrings = new ArrayList<>(stringMap.keySet());
        sortedStrings.sort((s1, s2)->{
            if (stringMap.get(s2).equals(stringMap.get(s1))) {
                return s1.compareTo(s2);
            }
            return stringMap.get(s2) - stringMap.get(s1);
        });

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(sortedStrings.get(i));
        }
        return res;
    }
}
