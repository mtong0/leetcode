from typing import List    

class No665:
    def letterCombinations(self, digits: str) -> List[str]:
        d = {
            "1": [""],
            "2": ["a", "b", "c"], 
            "3": ["d", "e", "f"],
            "4": ["g", "h", "i"],
            "5": ["j", "k", "l"],
            "6": ["m", "n", "o"],
            "7": ["p", "q", "r", "s"],
            "8": ["t", "u", "v"],
            "9": ["w", "x", "y", "z"]
        }
        res = []

        def concat(i, s):
            if i == len(digits):
                res.append(s)
                return
            
            if digits[i] == "1":
                concat(i+1, s)
            else:  
                for c in d[digits[i]]:
                    s += c
                    concat(i+1, s)
                    s = s[:-1]

        concat(0, "")
        return res

print(No665().letterCombinations("12"))