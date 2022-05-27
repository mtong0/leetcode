from typing import List


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0 for i in range(n+1)] for j in range(m+1)]

        for s in strs:
            zeros = s.count("0")
            ones = s.count("1")

            for i in range(m, zeros-1, -1):
                for j in range(n, ones-1, -1):
                    dp[i][j] = max(dp[i][j], dp[i-zeros][j-ones]+1)
        
        return dp[m][n]

print(Solution().findMaxForm(["10","0","1"], 1, 1))