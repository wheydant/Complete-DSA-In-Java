from collections import defaultdict
from typing import List


class Solution:
    #Any number of nodes can be halved before starting the first traversal itself. So we need freq
    def minimumTotalPriceWrongApproach(self, n: int, edges: List[List[int]], price: List[int], trips: List[List[int]]) -> int:
        tree = defaultdict(list)
        for u, v in edges:
            tree[u].append(v)
            tree[v].append(u)
        
        self.min_cost = 0

        def dfs(node, par, end, even, odd, isEven):
            if node == end:
                if even >= odd:
                    even = even//2
                else:
                    odd = odd//2
                
                self.min_cost += even + odd

                return
            
            if isEven:
                even += price[node]
            else:
                odd += price[node]
            
            for nei in tree[node]:
                if nei == par:
                    continue
                
                dfs(nei, node, end, even, odd, not isEven)

        for start, end in trips:
            if start == end:
                return price[start]//2
            dfs(start, -1, end, 0, 0, True)
        
        return self.min_cost
    
    def minimumTotalPrice(self, n: int, edges: List[List[int]], price: List[int], trips: List[List[int]]) -> int:
        tree = defaultdict(list)
        for u, v in edges:
            tree[u].append(v)
            tree[v].append(u)
        
        # Freq of nodes after all trips
        freq = [0]*n
        
        def find_path(u, target, parent, path):
            if u == target:
                path.append(u)
                return True
            for nei in tree[u]:
                if nei == parent:
                    continue
                if find_path(nei, target, u, path):
                    path.append(u)
                    return True
            return False
        
        for u, v in trips:
            path = []
            find_path(u, v, -1, path)
            for node in path:
                freq[node] += 1
        
        # Tree Dp
        def dfs(node, parent):
            not_half = freq[node]*price[node]
            half = freq[node]*price[node] // 2
            
            for nei in tree[node]:
                if nei == parent:
                    continue
                
                child_not_half, child_half = dfs(nei, node)
                
                # If current not halved -> child can choose min
                not_half += min(child_not_half, child_half)
                
                # If current halved then child cannot be halved
                half += child_not_half
            
            return not_half, half
        
        return min(dfs(0, -1))

if __name__ == '__main__':
    print(Solution().minimumTotalPrice(4, [[0,1],[1,2],[1,3]], [2,2,10,6], [[0,3],[2,1],[2,3]]))
    # print(Solution().minimumTotalPrice(2, [[0,1]], [2,2], [[0,0]]))