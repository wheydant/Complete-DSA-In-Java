from typing import List


class Solution:
    def countHighestScoreNodes(self, parents: List[int]) -> int:
        n = len(parents)
        children = [[] for _ in range(n)]
        for i in range(1, n):
            children[parents[i]].append(i)
        # print(children)
        # print(parents)

        self.max_score = 0
        self.count = 0

        def dfs(node):
            score = 1
            # size of current subtree for leaf it returns 1 at the end
            size = 0

            # Compute subtree sizes of children
            for child in children[node]:
                child_size = dfs(child)
                score *= child_size
                size += child_size
            
            # Remaining tree size (parent side)
            remaining = n - size - 1
            if remaining > 0:
                score *= remaining
            
            # Update
            if score > self.max_score:
                self.max_score = score
                self.count = 1
            elif score == self.max_score:
                self.count += 1
            
            return size + 1

        dfs(0)
        return self.count
        return 0
        