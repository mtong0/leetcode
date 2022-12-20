package src.algorithm.temp;
import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * */
public class LongestSubstringWithoutRepeatingCharacters {

    //method 1 (sliding window)
    public int lengthOfLongestSubstring1(String s) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0) {
                map.put(c, 1);
                right += 1;
            } else {
                break;
            }
        }
        max = right;

        int left = 0;
        int l = s.charAt(left);
        while (right < s.length()) {
            int r = s.charAt(right);
            if (!map.containsKey(r)) {
                map.put(r, 1);
            } else {
                map.put(r, map.get(r)+1);
            }
            while (map.get(r) > 1) {
                map.put(l, map.get(l)-1);
                l = s.charAt(++left);
            }
            max = Math.max(max, right-left+1);
            right++;
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            int c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            map.put(c, j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2("uqinntq"));
    }
}
