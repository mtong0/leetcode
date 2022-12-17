import heapq
from typing import List
from queue import PriorityQueue

class No665:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        l = []
        s = 0
        cross = 0

        for i in range(len(heights)-1):
            if heights[i+1] > heights[i]:
                diff = heights[i+1] - heights[i]
                s += diff

                heapq.heappush(l, (diff, i+1))
                cross += diff

                if len(l) > ladders:
                    d = heapq.heappop(l)
                    cross -= d[0]
                
                if s - cross > bricks:
                    return i
            
print(No665().furthestBuilding([4,2,7,6,9,14,12], 5, 1))