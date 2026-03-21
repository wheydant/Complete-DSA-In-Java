from heapq import heappop, heappush
from typing import List


class Solution:
    def sort_k_sorted_array(self, arr: List[int], k):
        heap = []
        ans = []
        i = 0
        while i <= k + 1:
            heappush(heap, arr[i])
            i += 1
        
        while i < len(arr):
            least = heappop(heap)
            ans.append(least)
            heappush(heap, arr[i])
            i += 1
        
        while heap:
            ans.append(heappop(heap))
        
        return ans

if __name__ == "__main__":
    arr = [6, 5, 3, 2, 8, 10, 9]
    k = 3
    print(Solution().sort_k_sorted_array(arr, k))