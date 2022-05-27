from typing import List


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m = [[1 for i in range(len(maze[0])+2)] for j in range(len(maze)+2)]
        for i in range(0, len(maze)):
            for j in range(0, len(maze[0])):
                m[i+1][j+1] = maze[i][j]
        
        cur = [[start[0]+1, start[1]+1]]
        next = []
        his = [[0 for i in range(len(maze[0])+1)] for j in range(len(maze)+1)]
        his[cur[0][0]][cur[0][1]] = 1

        possible_points = [[],[],[],[]]
        while len(cur) > 0:
            p = cur.pop(0)
            possible_points[0] = self.roll([p[0], p[1]], [1, 0], m)
            possible_points[1] = self.roll([p[0], p[1]], [0, 1], m)
            possible_points[2] = self.roll([p[0], p[1]], [-1, 0], m)
            possible_points[3] = self.roll([p[0], p[1]], [0, -1], m)
            
            for i in range(4):
                point = possible_points[i]
                if his[point[0]][point[1]] != 1:
                    his[point[0]][point[1]] = 1
                    next.append(point)

                if point[0] == destination[0] and point[1] == destination[1]:
                    return True

            if len(cur) == 0:
                cur = next.copy()
                next.clear()

        return False

    def roll(self, point: List[int], direction: List[int], maze: List[List[int]]):
        while maze[point[0]][point[1]] != 1:
            point[0] += direction[0]
            point[1] += direction[1]
        
        return [point[0]-direction[0], point[1]-direction[1]]


Solution().hasPath([[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], [0,4], [4,4])
