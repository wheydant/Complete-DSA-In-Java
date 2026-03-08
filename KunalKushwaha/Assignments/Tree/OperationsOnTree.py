from collections import deque
from typing import List


class LockingTree:
    def __init__(self, parent: List[int]):
        self.parent = parent
        self.isLocked = [None]*len(parent)
        self.child = { i : [] for i in range(len(parent))}
        # 1 because it has -1 too
        for i in range(1, len(parent)):
            self.child[parent[i]].append(i)

    def lock(self, num: int, user: int) -> bool:
        if self.isLocked[num]:
            return False
        self.isLocked[num] = user
        return True

    def unlock(self, num: int, user: int) -> bool:
        if self.isLocked[num] != user:
            return False
        self.isLocked[num] = None
        return True

    def upgrade(self, num: int, user: int) -> bool:
        # Go reverse
        i = num
        # -1 represent root node encountered
        while i != -1:
            if self.isLocked[i]:
                return False
            i = self.parent[i]
        
        # Go Down using BFS
        lockedCount = 0
        q = deque([num])
        while q:
            n = q.popleft()
            if self.isLocked[n]:
                self.isLocked[n] = None
                lockedCount += 1
            # Order doesn't matter we have to push all the childs .extend adds all the childs
            q.extend(self.child[n])
        
        if lockedCount > 0:
            self.isLocked[num] = user
        
        return lockedCount > 0

    
    # def dfs(self, node, num):
    #     if not self.child[node]:
    #         return False
        
    #     if self.isLocked[node]:
    #         return False
        
    #     if node == num:
    #         return True
        
    #     child_nodes = child[node]
    #     cur_bool = False
    #     for i in range len(child_nodes):
    #         if cur:
    #             return True
    #         cur = cur or self.dfs(child_nodes[i], node)
        
    #     return cur

        

# Your LockingTree object will be instantiated and called as such:
# obj = LockingTree(parent)
# param_1 = obj.lock(num,user)
# param_2 = obj.unlock(num,user)
# param_3 = obj.upgrade(num,user)