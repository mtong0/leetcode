from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class No665:
    def __init__(self) -> None:
        self.max_depth = 0
        self.nodes = []

    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        self.dfs(root, 0)
        return sum(self.nodes)

    def dfs(self, root: Optional[TreeNode], cur_depth):
        if root == None:
            return

        if cur_depth > self.max_depth:
            self.max_depth = cur_depth
            self.nodes.clear()
            self.nodes.append(root.val)
        elif cur_depth == self.max_depth:
            self.nodes.append(root.val)
        
        self.dfs(root.left, cur_depth+1)
        self.dfs(root.right, cur_depth+1)
        
