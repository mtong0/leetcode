package src.backtrack;

public class No10 {
    String s;
    String p;
    boolean[][] mem;
    int[][] visit;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        mem = new boolean[s.length()][p.length()];
        visit = new int[s.length()][p.length()];
        return backtrack(0, 0);
    }

    public boolean backtrack(int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        } else if (j >= p.length()) {
            return false;
        } else if (i >= s.length()) {
            while (j < p.length()) {
                if (j + 1 >= p.length()) return false;
                if (p.charAt(j+1) != '*') return false;
                j += 2;
            }
            return true;
        }

        if (visit[i][j] == 1) {
            return mem[i][j];
        }

        visit[i][j] = 1;
        boolean flag = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j + 1 < p.length() && p.charAt(j+1) == '*') {
                flag = backtrack(i+1, j) || backtrack(i+1, j+2) || backtrack(i, j+2);
            } else {
                flag = backtrack(i+1, j+1);
            }
        } else if (j + 1 < p.length() && p.charAt(j+1) == '*') {
            flag = backtrack(i, j+2);
        }
        mem[i][j] = flag;
        return flag;
    }

    public static void main(String[] args) {
        String s = "bbbba";
        String p = ".*a*a";
        new No10().isMatch(s, p);
    }
}
