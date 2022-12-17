package src;

import java.util.HashMap;
import java.util.List;

public class No1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int n = word1.length();

        HashMap<Integer, Integer> countMap1 = new HashMap<>();
        HashMap<Integer, Integer> countMap2 = new HashMap<>();

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < n; i++) {
            count1[word1.charAt(i)-'a'] += 1;
            count2[word2.charAt(i)-'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0) {
                countMap1.put(count1[i], countMap1.getOrDefault(count1[i], 0) + 1);
            }
            if (count2[i] > 0) {
                countMap2.put(count2[i], countMap2.getOrDefault(count2[i], 0) + 1);
            }

            if ((count1[i] == 0 && count2[i] != 0) || (count1[i] != 0 && count2[i] == 0)) {
                return false;
            }
        }

        if (countMap1.keySet().size() != countMap2.keySet().size()) return false;
        for (int key: countMap1.keySet()) {
            if (!countMap2.containsKey(key)) return false;
            if (!countMap1.get(key).equals(countMap2.get(key))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        No1657 no1657 = new No1657();
        System.out.println(no1657.closeStrings(s1, s2));
    }
}
