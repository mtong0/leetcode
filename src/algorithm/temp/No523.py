from typing import List

class No665:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        sum = 0
        rs = [0 for _ in range(len(nums))]

        map = {}
        for i in range(len(nums)):
            sum = (sum + nums[i])%k
            rs[i] = sum
            if rs[i] == 0:
                return True
            if rs[i] in map:
                if map[rs[i]] < i - 1:
                    return True
            map[rs[i]] = i 

        return False


