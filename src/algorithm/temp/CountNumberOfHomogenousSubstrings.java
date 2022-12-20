package src.algorithm.temp;
public class CountNumberOfHomogenousSubstrings {
    String s;
    public int countHomogenous(String s) {
        this.s = s;
        return dp(s.charAt(0), 1);
    }

    public int dp(char c, int i) {
        if(i == s.length())  {
            return 1;
        }

        int current;
        int count = 1;
        int j;
        for (j = i; j < s.length(); j++) {
            if (c == s.charAt(j)) count++;
            else break;
        }

        if (j == s.length()) {
            current = cal(count);
        } else {
            current = cal(count) + dp(s.charAt(j), j+1);
        }
        return current;
    }

    public int cal(int n) {
        int res = 0;
        for (int i = n; i > 0; i--) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "zzzzz";
        System.out.println(new CountNumberOfHomogenousSubstrings().countHomogenous(s));
    }
}
