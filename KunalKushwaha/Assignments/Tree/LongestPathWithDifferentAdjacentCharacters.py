from heapq import nlargest
from typing import List


class Solution:
    def longestPath(self, parent: List[int], s: str) -> int:
        children = [[] for i in range(len(s))]

        for i,j in enumerate(parent):
            if j >= 0:
                children[j].append(i)
        
        self.largestPath = 0

        def dfs(node):
            candidate = [0]
            for child in children[node]:
                # Collect values from all the childrens
                curChild = dfs(child)
                # Append if their char value is different
                if s[node] != s[child]:
                    candidate.append(curChild)
                
            # Fetch only top 2 paths as path can be one branch, curr node, another branch.
            # heapq's method nlargest does the exact thing for us
            candidate = nlargest(2, candidate)

            self.largestPath = max(self.largestPath, sum(candidate) + 1)

            # Pass to the parent only one path with itself to make its own 2 branch for the max outcome
            return max(candidate) + 1
        
        dfs(0)
        return self.largestPath
            