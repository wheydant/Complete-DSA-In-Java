class Solution:
    def rootCount(self, edges: List[List[int]], guesses: List[List[int]], k: int) -> int:
        
        graph = defaultdict(list)

        for u,v in edges:
            graph[u].append(v)
            graph[v].append(u)

        guess = {}

        # Construct quick look up for the guesses
        for u,v in guesses:
            _u_v = str(u) + '~' + str(v)
            guess[_u_v] = True

        # Calculate guess for zero using dfs
        self.zero_guess = 0
        def dfs(node, par):
            for nei in graph[node]:
                if nei != par:
                    _node_nei = str(node) + '~' + str(nei)
                    if _node_nei in guess:
                        self.zero_guess += 1
                    
                    dfs(nei, node)

        dfs(0, -1)

        self.correct_root = 0

        def reroute(cur_guess, cur, par):
            if cur_guess >= k:
                self.correct_root += 1
            
            for nei in graph[cur]:
                if nei != par:
                    # Start re-routing from current node to all its neighbors
                    _cur_nei = str(cur) + '~' + str(nei)
                    _nei_cur = str(nei) + '~' + str(cur)

                    # If link moves from cur -> nei we break it and reverse it
                    if guess.get(_cur_nei,False):
                        cur_guess -= 1
                    if guess.get(_nei_cur, False):
                        cur_guess += 1
                    
                    reroute(cur_guess, nei, cur)

                    # Backtracking
                    if guess.get(_cur_nei, False):
                        cur_guess += 1
                    if guess.get(_nei_cur, False):
                        cur_guess -= 1
        
        reroute(self.zero_guess, 0, 0)

        return self.correct_root