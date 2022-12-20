from typing import List

class No665:
    def coinChange(self, coins: List[int], amount: int) -> int:
        coins.sort(reverse=True)
        return self.helper(coins, amount, len(coins)-1)

    def helper(self, coins: List[int], amount: int, coin_index) -> int:
        if amount == 0:
            return 0

        max_coin = 0
        for k in range(coin_index, -1, -1):
            coin = coins[k]
            max_coin = int(amount / coin)
            if max_coin != 0:
                for i in range(max_coin, -1, -1):
                    count = self.helper(coins, amount - i * coin, coin_index-1)
                    if count != -1:
                        return count + i 
        
        return -1

print(No665().coinChange([186,419,83,408], 6249))