Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        len = 0
        node = head
        while node:
            len += 1
            node = node.next
        
        def reverse(node, k, len):
            if not node or len < k:
                return node
            
            prev = next = None
            curr = node
            n = 0

            while curr and n < k:
                next = curr.next
                curr.next = prev
                prev = curr
                curr = next
                n += 1
                len -= 1
            
            if next:
                node.next = reverse(next, k, len)
            
            return prev
        
        return reverse(head, k, len)