"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root == None:
            return root
        layer = [root]
        next_layer = []

        while len(layer) != 0:
            for i in range(len(layer)):
                if i + 1 == len(layer):
                    layer[i].next = None
                else:  
                    layer[i].next = layer[i+1]
                
                if layer[i].left != None:
                    next_layer.append(layer[i].left)
                if layer[i].right != None:
                    next_layer.append(layer[i].right)

            layer.clear()
            layer += next_layer
            next_layer.clear()
            
        return root
        