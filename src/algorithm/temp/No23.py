import heapq
import imp
from typing import List
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class No665:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        h = []
        
        for node in lists:
            heapq.heappush(h, node)
            node = node.next
    
        root = heapq.heappop(h)
        node = root

        if root.next != None:
            heapq.heappush(root.next)
        heapq.heappush
        while(True):
            

