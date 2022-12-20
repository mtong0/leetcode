package src.algorithm.temp;
import java.util.Arrays;
import java.util.HashSet;

public class FindUniqueBinaryString {
    int n;
    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        HashSet<String> numbers = new HashSet<String>(Arrays.asList(nums));
        String res = "0".repeat(n+1);
        while (true) {
            res = plusOne(res);
            if (!numbers.contains(res)) return res;
        }
    }

    public String plusOne(String s) {
        StringBuilder str = new StringBuilder(s);
        int carry = 0;
        int sum = 1;
        for (int i = n-1; i >= 0; i--) {
            sum += carry + (s.charAt(i)-'0');
            if (sum == 1) {
                str.setCharAt(i, '1');
            } else if (sum == 2) {
                str.setCharAt(i, '0');
                carry = 1;
            } else if (sum == 3) {
                str.setCharAt(i, '1');
                carry = 1;
            }
            sum = 0;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String[] nums = {"000","001"};
        String res = new FindUniqueBinaryString().findDifferentBinaryString(nums);
        System.out.println(res);
    }
}
