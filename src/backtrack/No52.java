package src.backtrack;

public class No52 {
    int[][] attackedBoard;
    int[] attackedVertical;
    int count;
    int n;
    public int totalNQueens(int n) {
        attackedBoard = new int[n][n];
        attackedVertical = new int[n];
        this.n = n;
        placeQueen(0);
        return count;
    }

    public void placeQueen(int i) {
        if (i == n) {
            count += 1;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (attackedVertical[j] > 0) continue;
            if (attackedBoard[i][j] == 0) {
                changeAttackStatus(i, j, 1);
                placeQueen(i + 1);
                changeAttackStatus(i, j, -1);
            }
        }
    }

    public void changeAttackStatus(int i, int j, int val) {
        attackedVertical[j] += val;
        int a = i;
        int b = j;
        while (a < n-1 && b < n-1)
            attackedBoard[++a][++b] += val;

        a = i;
        b = j;
        while (a > 0 && b < n-1)
            attackedBoard[--a][++b] += val;

        a = i;
        b = j;
        while (a < n-1 && b > 0)
            attackedBoard[++a][--b] += val;

        a = i;
        b = j;
        while (a > 0 && b > 0)
            attackedBoard[--a][--b] += val;
    }

    public static void main(String[] args) {
        No52 no52 = new No52();
        System.out.println(no52.totalNQueens(5));
    }
}
