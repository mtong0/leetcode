# Definition for singly-linked list.
from typing import Optional
from ListNode import ListNode
class No665:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        node = head
        count = 0
        while node != None:
            count += 1
            node = node.next
        
        pos = count - n

        node = head
        for i in range(pos):
            node = node.next

        node.next = node.next.next

        return head