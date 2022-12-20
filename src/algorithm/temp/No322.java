package src.algorithm.temp;
import java.util.HashMap;
import java.util.Map;

class No322 {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> resDict = new HashMap<Integer, Integer>();
        resDict.put(amount, 10000);
        return this.dp(coins, amount, resDict);
    }

    public int dp(int[] coins, int amount, Map<Integer, Integer> resDict) {
        if(amount == 0) {
            return 0;
        } else {
            for(int c: coins) {
                if(amount >= c) {
                    resDict.put(
                        amount, 
                        Math.min(
                            resDict.getOrDefault(amount, 10000),
                            dp(coins, amount-c, resDict)    
                        ));
                }
            }
        }
        return resDict.getOrDefault(amount, 10000);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int amount = 11;
        System.out.println(new No322().coinChange(arr, amount));
    }
}