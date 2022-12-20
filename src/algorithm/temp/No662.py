from operator import ne
from turtle import left, right
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class No665:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        cur = [(root, "")]
        next = []
        res = 0
        while len(cur) > 0:
            node = cur.pop(0)
            if node.left != None:
                next.append((root.left, node[1]+"0"))
            if node.right != None:
                next.append((root.right, node[1]+"1"))

            if len(cur) == 0:
                res = max(res, int(next[-1][1], 2) - int(next[0][1], 2))
                cur = next.copy()
                next.clear()

        return res + 1 