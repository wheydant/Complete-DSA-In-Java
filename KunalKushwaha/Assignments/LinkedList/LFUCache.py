class ListNode:
    def __init__(self, val, prev = None, next = None):
        self.val = val
        self.prev = prev
        self.next = next

class LinkedList:
    def __init__(self):
        #Initialize 2 dummy left and right to avoid edge cases
        #Extreme Left Node
        self.left = ListNode(0)
        #Extreme Right Node
        self.right = ListNode(0, self.left)
        self.left.next = self.right
        #Main Linked List, holds value to node mapping to manipulate linked list easily
        self.map = {}
    
    def length(self):
        return len(self.map)
    
    def pushRight(self, val):
        node = ListNode(val, self.right.prev, self.right)
        self.map[val] = node
        #Breaking bonds
        self.right.prev = node
        node.prev.next = node
    
    def pop(self, val):
        # Handles if value is not present per count for key edge case
        if val in self.map:
            node = self.map[val]
            next, prev = node.next, node.prev
            next.prev = prev
            prev.next = next
            self.map.pop(val, None)
    
    def popLeft(self):
        res = self.left.next.val
        self.pop(res)
        return res
    def update(self, val):
        #Remove from original place and push to right
        self.pop(val)
        self.pushRight(val)


class LFUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.lfuCnt = 0
        # Maps key to value
        self.valMap = {}
        # Maps key to frequency count
        self.countMap = collections.defaultdict(int)
        # Maps count of key to linkedList for each count
        self.listMap = collections.defaultdict(LinkedList)
    
    def counter(self, key):
        cnt = self.countMap[key]
        self.countMap[key] += 1
        # Edge case
        self.listMap[cnt].pop(key)
        self.listMap[cnt + 1].pushRight(key)

        # If lfuCnt's Linkedlist is empty
        if cnt == self.lfuCnt and self.listMap[cnt].length() == 0:
            self.lfuCnt += 1
    
    def get(self, key: int) -> int:
        if key not in self.valMap:
            return -1
        
        self.counter(key)
        return self.valMap[key]
        

    def put(self, key: int, value: int) -> None:
        # Extreme dumb edge case
        if self.cap == 0:
            return
        
        # Removing LFU
        if key not in self.valMap and len(self.valMap) == self.cap:
            res = self.listMap[self.lfuCnt].popLeft()
            self.valMap.pop(res)
            self.countMap.pop(res)
        
        self.valMap[key] = value
        self.counter(key)
        self.lfuCnt = min(self.lfuCnt, self.countMap[key])

        


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)