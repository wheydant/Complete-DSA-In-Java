from collections import deque
from heapq import heapify, heappop, heappush
from typing import Counter, List


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # Counts all the unique tasks
        count = Counter(tasks)
        maxHeap = [-cnt for cnt in count.values()]
        heapify(maxHeap)

        time = 0
        q = deque() # pair of [-cnt, idleTime]

        while maxHeap or q:
            time += 1
            if maxHeap:
                # 1 - 1 = 0 thus eliminating the need to add in queue
                cnt = 1 + heappop(maxHeap)
                if cnt:
                    q.append([cnt, time + n])
            if q and q[0][1] == time:
                # Push into heap only when cooldown is complete
                heappush(maxHeap, q.popleft()[0])
        
        return time
