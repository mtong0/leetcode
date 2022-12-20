package src.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        int length = words[0].length();
        int validLength = words.length * length;
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String str: words) {
            wordMap.put(str, wordMap.getOrDefault(str, 0) + 1);
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i;
            while (temp.length() > 0) {
                String popString = temp.substring(0, length);
                temp.replace(0, length, "");
                wordMap.put(popString, wordMap.get(popString) + 1);
            }
            while (left < s.length() && right + length <= s.length()) {
                String nextString = s.substring(right, right + length);
                if (wordMap.containsKey(nextString) && wordMap.get(nextString) > 0) {
                    wordMap.put(nextString, wordMap.get(nextString) - 1);
                    temp.append(nextString);
                    right += length;
                } else if (!wordMap.containsKey(nextString)) {
                    while (temp.length() > 0) {
                        String popString = temp.substring(0, length);
                        temp.replace(0, length, "");
                        wordMap.put(popString, wordMap.get(popString) + 1);
                    }
                    left = right += length;
                } else {
                    left += length;
                    if (temp.length() > 0) {
                        String outputString = temp.substring(0, length);
                        temp.replace(0, length, "");
                        wordMap.put(outputString, wordMap.get(outputString) + 1);
                    }
                }
                if (temp.length() == validLength) {
                    res.add(left);
                    String outputString = temp.substring(0, length);
                    wordMap.put(outputString, wordMap.get(outputString) + 1);
                    temp.replace(0, length, "");
                    left += length;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No30().findSubstring("aaaaa", new String[]{"aa","aa"}));
    }
}
