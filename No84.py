from typing import List


class No665:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.append(0)
        stack = []
        stack.append((heights[0], 0))
        res = 0

        for i in range(1, len(heights)): 
            index = i
            while True:
                if len(stack) == 0:
                    break

                top = stack[-1]
                if top[0] > heights[i]:
                    index = top[1]
                    res = max(res, top[0]*(i-top[1]))
                    stack.pop()
                else:
                    break

            stack.append((heights[i], index))
        
        return res
            

