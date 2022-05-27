class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = []
        indexes = [0 for i in range(len(s))]

        for i in range(len(s)):
            c = s[i]
            if c == '(':
                stack.append((c, i))
            elif c == ')':
                if stack[-1][0] == '(':
                    indexes[stack[-1][1]] = 1
                    indexes[i] = 1
                    stack.pop()
            
    

        return max_count
    