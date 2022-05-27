from collections import defaultdict
from typing import List

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        map = defaultdict(int)
        for i in range(len(nums)):
            map[nums[i]] += 1
    
        res = []
    
        self.dp(map, len(map.keys()), [], res)
        
        return res
    
    def dp(self, map: dict, key_num: int, l: List, res):
        if key_num == 1:
            for key in map.keys():
                if map[key] != 0:
                    l += [key for i in range(map[key])]
                    res.append(l.copy())
                    del l[-len(map[key]):]
                    return

        for key in map.keys():
            if map[key] == 0:
                 continue
            map[key] -= 1
            l.append(key)
            if map[key] == 0:
                self.dp(map, key_num-1, l, res)
            else:
                self.dp(map, key_num, l, res)
            l.pop()
            map[key] += 1

        return

nums = [1, 2, 3]
Solution().permuteUnique(nums)