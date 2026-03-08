from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class main:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        def helper(node: Optional[TreeNode]) -> List[int]:
            if node == None:
                return []
            return [node.val] + helper(node.left) + helper(node.right)
        return helper(root)

if __name__ == '__main__':
    executor = main()
    print(executor.preorderTraversal(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6), TreeNode(7))), TreeNode(3, None, TreeNode(8, TreeNode(9))))))