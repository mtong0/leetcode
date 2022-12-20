from typing import List

class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.sums = [0 for _ in range(len(nums))]
        s = 0
        for i in range(len(nums)):
            s += nums[i]
            self.sums[i] = s 
        

    def sumRange(self, left: int, right: int) -> int:
        if left == right:
            return self.nums[left]
        return self.sums[right]-self.sums[left]+self.nums[left]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)