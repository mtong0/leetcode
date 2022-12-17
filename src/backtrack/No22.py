from typing import List


class No22:
    def generateParenthesis(self, n: int) -> List[str]:
        
        count = 0
        curr = 0 # how many left pa left

        res = []
        def backtrack(s, count, curr):
            if count == n and curr == 0:
                res.append(s)
                return

            if count < n:
                s += "("
                curr += 1
                count += 1
                backtrack(s, count, curr)
                s = s[:-1]
                curr -= 1
                count -= 1
            
            if curr > 0:
                s += ")"
                curr -= 1
                backtrack(s, count, curr)
                s = s[:-1]
                curr += 1
        
        backtrack("", 0, 0)

        return res