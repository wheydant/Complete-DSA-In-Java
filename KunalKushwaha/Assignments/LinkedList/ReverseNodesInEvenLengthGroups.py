# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseEvenLengthGroups(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        prev = dummy
        curr = head
        groupSize = 1

        while curr:
            count = 0
            temp = curr

            while temp and count < groupSize:
                temp = temp.next
                count += 1
            
            if count % 2 == 0:
                prev.next = self.reverse(curr, count)
                curr.next = temp
                prev = curr
                curr = temp
            else:
                for _ in range(count):
                    prev = curr
                    curr = curr.next
            
            groupSize += 1
        return dummy.next
    
    def reverse(self, head: ListNode, k:int) -> ListNode:
        prev = None
        curr = head
        # Quite good method to reverse Linked List
        while k > 0:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
            k -= 1
        return prev