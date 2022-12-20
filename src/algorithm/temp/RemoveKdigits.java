package src.algorithm.temp;
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        for (int i = 0; i < k; i++) {
            char max = '0';
            for (int j = 0; j < num.length(); j++) {
                if (num.charAt(j) >= max) {
                    max = num.charAt(j);
                    if (j == num.length()-1) {
                        num = num.substring(0, j);
                        break;
                    }
                } else {
                    num = num.substring(0, j-1) + num.substring(j);
                    break;
                }
            }
        }
        if (num.equals("")) return "0";
        else {
            while (num.charAt(0) == '0') {
                num = num.substring(1);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String num = "9";
        int k = 1;
        System.out.println(new RemoveKdigits().removeKdigits(num, k));
    }
}
