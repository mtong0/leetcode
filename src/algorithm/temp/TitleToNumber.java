package src.algorithm.temp;
public class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        int number = 0;
        for (int i = 1; i < columnTitle.length(); i++) {
            number += (int) Math.pow(26,i);
        }

        for (int i = 0; i < columnTitle.length(); i++) {
            number += (columnTitle.charAt(i) - 'A') * Math.pow(26, columnTitle.length()-i-1);
        }

        return number+1;
    }

    public static void main(String[] args) {
        System.out.println(new TitleToNumber().titleToNumber("ZY"));
    }
}
