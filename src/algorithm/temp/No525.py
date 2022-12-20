from typing import List

class No665:
    def findMaxLength(self, nums: List[int]) -> int:
        sums = [0 for _ in range(len(nums)+1)]
        for i in range(1, len(nums)+1):
            sums[i] = sums[i-1] + nums[i-1]
        
        dp = [0 for _ in range(len(nums))]

        