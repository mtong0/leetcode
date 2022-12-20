package src.algorithm.hashtable;

import java.util.Arrays;

public class No3 {
    public int lengthOfLongestSubstring(String s) {
        int[] flags = new int[26];
        Arrays.fill(flags, -1);
        int i = 0;
        int j = 0;

        flags[s.charAt(0)-'a'] = i;
        int max_value = 0;
        int exist = 0;
        for (int k = 1; k < s.length(); k++) {
            j = k;
            exist = flags[s.charAt(k)-'a'];
            flags[s.charAt(k)-'a'] = k;
            if (exist != -1) {
                i = exist + 1;
                max_value = Math.max(max_value, j-i);
            } else {
                max_value = Math.max(max_value, j-i+1);
            }
        }

        return max_value;
    }
}
