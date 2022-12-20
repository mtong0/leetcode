from typing import List


class No665:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        start = []
        end = []

        product = 1
        for i in range(len(nums)):
            product *= nums[i]
            end.append(product)
        
        product = 1
        for i in range(len(nums)-1, -1, -1):
            product *= nums[i]
            start.insert(0, product)
        
        res = [start[0]]
        for i in range(1, len(nums)-1):
            res.append(end[i-1]*start[i+1])

        res.append(end[len(nums)-2])

        return res