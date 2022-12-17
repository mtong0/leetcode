package src.dp;

import java.util.Arrays;

public class No322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 1; i < amount + 1; i++) {
            for (int coin: coins)  {
                if (i - coin >= 0 && dp[i-coin] != -1) {
                    if (dp[i] == -1)
                        dp[i] = dp[i - coin] + 1;
                    else
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(new No322().coinChange(coins, amount));
    }
}
