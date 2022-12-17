from re import I, L
from typing import List

class No665:
    def smallestFactorization(self, num: int) -> int:
        factors = []

        while True:
            num = self.getNum(num, factors)
            if num == 1:
                break
            if num == -1:
                return 0

        res = 0
        for i in range(len(factors)):
            res += pow(10, i) * factors[i]
    
        if res > 2147483647:
            res = 0
        
        return res

    
    def getNum(self, num, factors):
        for i in range(9, 1, -1):
            if num % i == 0:
                num /= i
                factors.append(i)
                return num

        return -1

No665().smallestFactorization(11)