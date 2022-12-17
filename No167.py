from operator import contains
from typing import List

class No665:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        num_map = {}
        for i in range(numbers):
            if target - numbers[i] in num_map:
                return [num_map[target-numbers[i]], i]
            else:
                num_map[numbers[i]] = i
