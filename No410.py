from main.src.math import floor
import sys
from typing import List


class No665:
    def splitArray(self, nums: List[int], m: int) -> int:
        l = 0
        r = sum(nums)
        

        while True:
            v = floor((l+r) / 2)
            s = 0
            count = 1
            for i in range(len(nums)):
                if nums[i] > v:
                    count = 51
                    break
                elif s + nums[i] > v:
                    s = 0
                    s += nums[i]
                    count += 1
                else:
                    s += nums[i]
            
            if count > m:
                l = v + 1
            else:
                r = v
            
            if l >= r:
                return r

#         dp = [[0 for i in range(m)] for j in range(len(nums))]

#         total = 0
#         for i in range(len(nums)):
#             total += nums[i]
#             dp[0][i] = total 
        
#         cur = sys.maxsize
#         for i in range(1, m):
#             if i == m - 1:
#                 print()
#             for j in range(i, len(nums)):
#                 for k in range(i-1, j):
#                     cur = min(cur, max(dp[i-1][k], dp[0][j] - dp[0][k]))
                
#                 dp[i][j] = cur
#                 cur = sys.maxsize
        
#         return dp[m-1][len(nums)-1]


print(No665().splitArray([1, 4, 4], 3))

