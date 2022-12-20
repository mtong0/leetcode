package src.algorithm.other;

public class No8 {
    public int myAtoi(String s) {
        s = s.strip();
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        char sign = s.charAt(i);
        int maxNum = (1<<31)-1;
        if (sign == '+' || sign == '-') {
            i += 1;
            if (sign == '-') {
                maxNum = 1<<31;
            }
        } else {
            sign = '+';
        }

        int res = 0;
        
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break;
            if (res > Integer.MAX_VALUE / 10) {
                return maxNum;
            }

            if (sign == '-' && (res * 10 > maxNum - (c-'0') && c != '0')) {
                return maxNum;
            }

            if (sign == '+' && res * 10 > maxNum - (c-'0')) {
                return maxNum;
            } 
            res = res * 10 + c - '0';
        }

        if (res == 1<<31) return res;
        if (sign == '-') return -res;
        return res;
    }

    public static void main(String[] args) {
        String s = "-21474836482";
        new No8().myAtoi(s);
    }
}