package src.algorithm.temp;

public class LongestPalindromicSubstring {
    String s;
    int max;
    String maxS;
    public String longestPalindrome(String s) {
        this.s = s;
        for (int i = 0; i < s.length(); i++) {
            check(i, i);
        }
        return maxS;
    }

    public void check(int i, int j) {
        if (i == j || s.charAt(i) == s.charAt(j)) {
            if (j-i+1 > max) {
               maxS = s.substring(i, j+1);
               max = j-i+1;
            }
            if (i==j) {
                if (j+1 < s.length()) {
                    check(i, j+1);
                }
            }
            if (i-1 >=0 && j+1 < s.length()) {
                check(i-1, j+1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abb"));
    }
}
