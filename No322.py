from collections import defaultdict
from email.policy import default
from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        res_dict = defaultdict(lambda: 10000)
        res_dict[amount] = 10000
        res_dict[0] = 0

        self.dp(coins, amount, res_dict)

        return res_dict[amount]

    def dp(self, coins, amount, res_dict):
        if amount == 0:
            return 0
        else:
            for a in coins:
                if amount == 2:
                    print()
                if amount >= a:
                    res_dict[amount] = min(res_dict[amount], self.dp(coins, amount-a, res_dict)+1)

Solution().coinChange([1, 2, 5], 11)