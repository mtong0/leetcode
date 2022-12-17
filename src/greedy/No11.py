
from typing import List


class No665:
    def maxArea(self, height: List[int]) -> int:
        num_map = {}
        max_num = 0
        for i in range(len(height)):
            n = height[i]
            max_num = max(max_num, n)

            if n in num_map:
                if len(num_map[n]) < 2:
                    num_map[n].append(i)
                else:
                    num_map[n][1] = i
                
            else:
                num_map[n] = [i]
        
        left = 100000
        right = -1

        res = 0
        for l in range(max_num, 1, -1):
            if l in num_map:
                for k in num_map[l]:
                    left = min(left, k)
                    right = max(right, k)

                res = max(res, l*(right-left))

        return res

print(No665().maxArea([1,1]))