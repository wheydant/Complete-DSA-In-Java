from heapq import heapify, heappop
from typing import Counter, List


class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize:
            return False
        
        # Create a dict of keys and its count
        count = Counter(hand)
        # Append the keys in minHeap
        minHeap = list(count.keys())
        heapify(minHeap)

        while minHeap:
            # Form hands for lowest elements as it cannot be formed we cannot achieve a hand with it later
            first = minHeap[0]

            # first, first + 1, first + 2 .... first + n - 1
            for i in range(first, first + groupSize):
                if i not in count:
                    return False
                count[i] -= 1
                if count[i] == 0:
                    if i != minHeap[0]:
                        return False
                    heappop(minHeap)
        return True
        
