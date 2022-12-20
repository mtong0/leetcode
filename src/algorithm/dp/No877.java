package src.algorithm.dp;

public class No877 {
    int[][] mem;
    public boolean stoneGame(int[] piles) {
        mem = new int[piles.length][piles.length];
        int sum = 0;
        for(int pile: piles) {
            sum += pile;
        }

        int alice = dp(piles, 0, piles.length, sum);

        return alice > sum / 2;
    }

    public int dp(int[] piles, int left, int right, int sum) {
        if (mem[left][right] != 0) {
            return mem[left][right];
        }
        if (right-left == 1) {
            mem[left][right] = Math.max(piles[left], piles[right]);
            return mem[left][right];
        }

        int max = Math.max(
                Math.max(sum-dp(piles, left+1, right, sum-piles[left]), piles[left]),
                Math.max(sum-dp(piles, left, right-1, sum-piles[right]), piles[right]));
        mem[left][right] = max;
        return max;
    }
}
