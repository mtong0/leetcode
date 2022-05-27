from operator import ne
from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        next = nums[0]
        count = 1
        res = 0
        for i in range(1, len(nums)):
            if nums[i] > next:
                count += 1
            else:
                res = max(res, count)
                count = 1
            next = nums[i]
        
        return count-1

print(Solution().lengthOfLIS([0,1,0,3,2,3]))