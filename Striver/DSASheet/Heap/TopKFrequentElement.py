class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_map = {}
        heap = []
        for num in nums:
            freq_map[num] = freq_map.get(num, 0) + 1
        
        for key, value in freq_map.items():
            heappush(heap, (-value, key))

        # print(heap)
        ans = []
        while k:
            _, num = heappop(heap)
            ans.append(num)
            k -= 1

        return ans