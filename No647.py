class Solution:
    def countSubstrings(self, s: str) -> int:
        res = []
        for i in range(len(s)):
            res.append(s[i])

            if i+1 < len(s) and s[i] == s[i+1]:
                left = i
                right = i+1
                res.append(s[left:right+1])
                while left - 1 >= 0 and right + 1 < len(s) and s[left-1] == s[right+1]:
                    left -= 1
                    right += 1
                    res.append(s[left:right+1])
            
            if i - 1 >= 0 and i + 1 < len(s):
                left = i - 1
                right = i + 1
                res.append(s[left:right+1])
                while left - 1 >= 0 and right + 1 < len(s) and s[left-1] == s[right+1]:
                    left -= 1
                    right += 1
                    res.append(s[left:right+1])
        return res

print(Solution().countSubstrings("aaaa"))


