# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        dp = {}
        def solve(root, cam, parCam):
            # Strict Camera Rule is passed from parent which is not possible
            if not root:
                if cam:
                    return sys.maxsize
                else :
                    return 0
            
            if not root.left and not root.right:
                if cam:
                    return 1
                else:
                    if parCam:
                        return 0
                    # Wrong cas it doesn't have camera neither does the parrent
                    else:
                        return sys.maxsize
            
            cNode = (root, cam, parCam)

            # If Ans Already exist for this combination return it
            if cNode in dp:
                return dp[cNode]
            # If Camera is placed on this node then child has free will to whatever they want.
            elif cam: 
                dp[cNode] = 1 + min(solve(root.left, 0, 1), solve(root.left, 1, 1)) + min(solve(root.right, 0, 1), solve(root.right, 1, 1))
                return dp[cNode]
            # No Cam here tricky case arise
            else:
                # Easy this node is safe ask child to do as they wish
                if parCam:
                    dp[cNode] = min(solve(root.left, 0, cam), solve(root.left, 1, cam)) + min(solve(root.right, 0, cam), solve(root.right, 1, cam))
                    return dp[cNode]
                # Now tricky thing parent is not camera, current is also not monitored so we have to force atleast one of the child
                else :
                    # Left Mandatory and right has free will
                    op1 = solve(root.left, 1, 0) + min(solve(root.right, 0, 0), solve(root.right, 1, 0))
                    # Right Mandatory and left has free will
                    op2 = solve(root.right, 1, 0) + min(solve(root.left, 0, 0), solve(root.left, 1, 0))
                    # Min of this output
                    dp[cNode] = min(op1, op2)
                    return dp[cNode]
        
        return min(solve(root, 0, 0), solve(root, 1, 0))