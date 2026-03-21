# Heap Questions

https://takeuforward.org/dsa/strivers-a2z-sheet-learn-dsa-a-to-z

## Easy

1. [X][Implement Min Heap](https://www.geeksforgeeks.org/problems/min-heap-implementation/1)
	>**Note :** We create a tree using array using parent /2 and all logic. [CodeHelp 16:00](https://www.youtube.com/watch?v=NKJnHewiGdc) -> Log n Magic
2. [X][Does array represent Heap](https://www.geeksforgeeks.org/problems/does-array-represent-heap4345/1)
	>**Note :** Heap means parent is always greatest amongst left and right subtree
3. [X][Convert Min Heap to Max Heap](https://www.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109/1)
	>**Note :** Last Non leaf node - [(n // 2) - 1] which translates to -> (n-2)//2. Reverse loop in python `for i in range((N-2)//2, -1, -1)` swap elements `arr[i], arr[largest] = arr[largest], arr[i]`

## Medium

1. [X][Kth largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)
	heappush, heappop
2. [X][Kth Smallest](https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1)
3. [X][Sort K sorted array](https://takeuforward.org/data-structure/sort-k-sorted-array)
	Very Nice
4. [ ][Replace Elements By Their Rank](https://leetcode.com/problems/rank-transform-of-an-array/description/)
5. [ ][Task Scheduler](https://leetcode.com/problems/task-scheduler/)
6. [ ][Hand of Straights](https://leetcode.com/problems/hand-of-straights/)

## Hard
1. [ ][Merge k sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/description/)
2. [ ][Design Twitter](https://leetcode.com/problems/design-twitter/)
3. [ ][Minimum Cost to Connect Sticks](https://takeuforward.org/plus/dsa/problems/minimum-cost-to-connect-sticks?source=strivers-a2z-dsa-track)
4. [ ][Kth Largest Element In a stream of running integers](https://leetcode.com/problems/kth-largest-element-in-a-stream/#:~:text=Implement%20KthLargest%20class%3A,largest%20element%20in%20the%20stream.)
5. [ ][Maximum Sum Combination](https://www.geeksforgeeks.org/problems/maximum-sum-combination/0)
6. [ ][Find Medain from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)
7. [ ][Top k Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/description/)
