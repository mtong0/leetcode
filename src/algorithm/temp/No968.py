from asyncio.windows_events import NULL
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class No665:
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        node_list = []
        l = [root]
        while len(l) > 0:
            n = l.pop(0)
            node_list.append(n)
            if n != None and not (n.left == None and n.right == None):
                l.append(n.left)
                l.append(n.right)
        
        marked = [0 for i in range(len(node_list))]

        count = 0
        for i in range(len(node_list)-1, -1, -1):
            if marked[i] == 0 and node_list[i] != None:
                p = int((i-1)/2)
                marked[p] = 1
                count += 1
                if p-1 >= 0:
                    marked[int((p-1)/2)] = 0
                marked[p*2+1] = 1
                marked[p*2+2] = 1
        
        return count
    
t = TreeNode(0, TreeNode(0, TreeNode(0), TreeNode(0)))