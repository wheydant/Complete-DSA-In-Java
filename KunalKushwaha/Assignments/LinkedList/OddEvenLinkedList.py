from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
def oddEvenList(head: Optional[ListNode]) -> Optional[ListNode]:
        evenHead = ListNode(-1)
        even = evenHead
        oddHead = ListNode(-1)
        odd = oddHead
        isEven = False
        while(head):
            if isEven:
                even.next = head
                even = head
            else:
                odd.next = head
                odd = head
            head = head.next
            isEven = not isEven
        
        odd.next = evenHead.next
        even.next = None
        return oddHead.next
def oddEvenListOptimized(self, head: Optional[ListNode]) -> Optional[ListNode]:
    if not head:
        return None
    odd = head
    even = head.next
    even_head = even 
    while even and even.next:
        odd.next = even.next
        odd = odd.next
        even.next = odd.next
        even = even.next
    odd.next = even_head
    return head
if __name__ == '__main__':
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    ans = oddEvenList(head)
    while ans:
        print(f'{ans.val}')
        ans = ans.next