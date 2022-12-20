from random import random
from typing import List

class No665:

    def __init__(self, w: List[int]):
        self.w = w
        self.sums = [0 for _ in range(len(w))]
        self.sums[0] = w[0]
        for i in range(1, len(w)):
            self.sums[i] = self.sums[i-1] + w[i]

    def pickIndex(self) -> int:
        r = int((self.sums[-1]-self.sums[0]) * random()) + self.sums[0]

        left = 0
        right = len(self.sums)-1
        while(True):
            i = int((left + right) / 2)
            if r > self.sums[i] and r <= self.sums[i+1]:

                return self.w[i+1]
            elif r == self.sums[i]:
                return self.w[i]
            elif r < self.sums[i]:
                right = i
            elif r > self.sums[i+1]:
                left = i
        
s = No665([1, 3, 4])
print(s.pickIndex())
print(s.pickIndex())
print(s.pickIndex())
print(s.pickIndex())


