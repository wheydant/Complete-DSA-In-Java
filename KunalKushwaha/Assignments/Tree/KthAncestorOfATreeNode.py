class TreeAncestor:

    def __init__(self, n: int, parent: List[int]):
        self.LOG = (n).bit_length()
        self.up = [[-1] * self.LOG for _ in range(n)]

        for v in range(n):
            self.up[v][0] = parent[v]
        
        for j in range(1, self.LOG):
            for v in range(n):
                if self.up[v][j - 1] != -1:
                    self.up[v][j] = self.up[ self.up[v][j - 1] ][j - 1]

    def getKthAncestor(self, node: int, k: int) -> int:
        j = 0
        while k:
            if k & 1:
                node = self.up[node][j]
                if node == -1:
                    return -1
            k >>= 1
            j += 1
        
        return node
        


# Your TreeAncestor object will be instantiated and called as such:
# obj = TreeAncestor(n, parent)
# param_1 = obj.getKthAncestor(node,k)