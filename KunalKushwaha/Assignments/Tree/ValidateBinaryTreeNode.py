import sys
from typing import List
class main:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        hasParents = set(leftChild + rightChild)
        #remove() throws error if key is not present discard tries to remove
        # Remove the -1 if exist
        hasParents.discard(-1)
        #If every node is a parent then its a cycle
        if len(hasParents) == n:
            return False
        
        root = -1
        for i in range(n):
            if i not in hasParents:
                root = i
                break
        
        vis = set()
        def dfs(root):
            if root == -1:
                return True
            if root in vis:
                return False
            vis.add(root)
            
            return dfs(leftChild[root]) and dfs(rightChild[root])
        # DFS as well as check if all the nodes are visited
        return dfs(root) and len(vis) == n


if __name__ == "__main__":
    leftChild = [1, -1, 3, -1]
    rightChild = [2, -1, -1, -1]
    validator = main()
    
    result = validator.validateBinaryTreeNodes(n=4, leftChild=leftChild, rightChild=rightChild)
    
    print(result)
