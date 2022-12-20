from pickletools import markobject
from typing import List
class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.matrix = matrix
        self.s = [[0 for _ in range(len(matrix[0])+1)] for __ in range(len(matrix)+1)]

        for i in range(1, len(matrix)+1):
            for j in range(1, len(matrix[0])+1):
                self.s[i][j] = self.s[i-1][j] + self.s[i][j-1] - self.s[i-1][j-1] + matrix[i-1][j-1]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        if row1 == row2 and col1 == col2:
            return self.matrix[row1+1][col1+1]
        return self.s[row2+1][col2+1] - self.s[row2+1][col1] - self.s[row1][col2+1] + self.s[row1][col1]
# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)

NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]).sumRegion(2, 1, 4, 3)