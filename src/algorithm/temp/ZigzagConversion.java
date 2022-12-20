package src.algorithm.temp;
import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        List<List<Character>> zigzag = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            zigzag.add(new ArrayList<>());
        }

        int idxRow = 0;
        int idxC = 0;
        while (idxC != s.length()) {
            zigzag.get(idxRow).add(s.charAt(idxC));
            idxC++;
            idxRow++;
            if (idxRow == numRows) {
                idxRow = numRows-1;
                while (idxRow != 0 && idxC != s.length()) {
                    idxRow--;
                    zigzag.get(idxRow).add(s.charAt(idxC));
                    idxC++;
                }
                idxRow = Math.min(1, numRows-1);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < zigzag.size(); i++) {
            for (int j = 0; j < zigzag.get(i).size(); j++) {
                res.append(zigzag.get(i).get(j));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numsRow = 4;
        System.out.println(new ZigzagConversion().convert(s,numsRow));
    }
}
