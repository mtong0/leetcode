/**
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 */
public class PermutationInString {
    //method 1 (using array)
    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)-97] += 1;
        }

        int count = 0;
        int[] used = new int[26];
        for(int i = 0; i < s2.length() - s1.length() + 1; i++) {
            if (match1(chars, used, s2.substring(i, i + s1.length()))) {
                return true;
            }
        }
        return false;
    }
    public boolean match1(int[] chars, int[] used, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            if (chars[index] > 0) {
                used[index] += 1;
                chars[index] -= 1;
                count++;
            } else {
                for (int j = 0; j < 26; j++) {
                    chars[j] += used[j];
                    used[j] = 0;
                }
                return false;
            }
        }
        for (int j = 0; j < 26; j++) {
            chars[j] += used[j];
            used[j] = 0;
        }
        return count == s.length();
    }

    //method 2 (sliding window)
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i)-'a'] += 1;
            count2[s2.charAt(i)-'a'] += 1;
        }
        if (match2(count1, count2)) return true;

        for (int i = 1; i < s2.length() - s1.length() + 1; i++) {
            count2[s2.charAt(i-1)-'a'] -= 1;
            count2[s2.charAt(i+s1.length()-1)-'a'] += 1;
            if (match2(count1, count2)) return true;
        }
        return false;
    }

    public boolean match2(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) return false;
        }
        return true;
    }
}
