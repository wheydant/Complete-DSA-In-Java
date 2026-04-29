class Solution:
    def waysToBuildRooms(self, prevRoom: List[int]) -> int:

        # Returns total ways to build tree with cur as root and total node count of the subtree
        def dfs(cur):
            # One way to build tree and 1 node in subtree
            if not graph[cur]:
                return 1, 1
            
            ways = 1
            curNodeCnt = 0

            for child in graph[cur]:
                subTreeWays, subTreeNodeCnt = dfs(child)

                #nCr
                #combinations = fact[curNodeCnt+subTreeNodeCnt]//fact[curNodeCnt]//fact[subTreeNodeCnt]
                # math.comb(curNodeCnt+subTreeNodeCnt, curNodeCnt)
                combinations = (fact[curNodeCnt+subTreeNodeCnt]*invFact[curNodeCnt]*invFact[subTreeNodeCnt])%mod

                ways = (ways * subTreeWays * combinations)%mod

                curNodeCnt += subTreeNodeCnt

            return ways, curNodeCnt + 1
        
        # Competitve way to find nCr just remember
        mod = 10**9+7
        n = len(prevRoom)
        fact = [0]*n
        fact[0] = 1
        invFact = [0]*n
        invFact[0] = pow(1, mod - 2, mod)

        for i in range(1, n):
            fact[i] = (i*fact[i - 1])%mod
            invFact[i] = pow(fact[i], mod - 2, mod)
        
        # Directed Graph
        graph = defaultdict(list)

        for cur, pre in enumerate(prevRoom):
            graph[pre].append(cur)
        

        return dfs(0)[0]
