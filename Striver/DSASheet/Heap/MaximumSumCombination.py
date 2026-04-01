import heapq


class BruteSolution:
    def topKSumPairs(self, a, b, k):
        # code here
        pq = []
        for i in a:
            for j in b:
                cur_sum = i+j
                heapq.heappush(pq, cur_sum)
                if len(pq) > k:
                    heapq.heappop(pq)
        
        pq.sort(reverse = True)
        
        return pq
            
class OptimizedSolution:
    def topKSumPairs(self, a, b, k):
        # code here
        a.sort(reverse=True)
        b.sort(reverse=True)
        
        n,m = len(a), len(b)
        
        max_heap = []
        vis = set()
        
        # push first
        heapq.heappush(max_heap, (-(a[0] + b[0]), 0, 0))
        vis.add((0, 0))
        
        result = []
        
        while k > 0 and max_heap:
            cur_sum, i, j = heapq.heappop(max_heap)
            result.append(-cur_sum)
            
            #i + 1, j
            if i + 1 < n and (i + 1, j) not in vis:
                heapq.heappush(max_heap, (-(a[i + 1] + b[j]), i + 1, j))
                vis.add((i + 1, j))
                
            #i, j + 1
            if j + 1 < m and (i, j + 1) not in vis:
                heapq.heappush(max_heap, (-(a[i] + b[j + 1]), i, j + 1))
                vis.add((i, j + 1))
            
            k-=1
        
        return result