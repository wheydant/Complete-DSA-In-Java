# Videos
- [Bubble Sort](https://youtu.be/F5MZyqRp_IM)
- [Selection Sort](https://youtu.be/Nd4SCCIHFWk)
- [Insertion Sort](https://youtu.be/By_5-RRqVeE)
- [Cycle Sort](https://www.youtube.com/watch?v=JfinxytTYFQ&list=RDCMUCBGOUQHNNtNGcGzVq5rIXjw&start_radio=1&rv=JfinxytTYFQ&t=2)
- [Merge Sort](https://youtu.be/iKGAgWdgoRk)
- [Quick Sort](https://youtu.be/Z8svOqamag8)

# Questions

Total - 43

Done - 6

## Easy
1. [X][Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
1. [X][Majority Element](https://leetcode.com/problems/majority-element/)

    - You increase the count for a candidate when you see the same number.
    - You decrease the count when the number is different.
    - If the count reaches 0, you choose a new candidate.
    - This works because the majority element appears more than half the time, so it cannot be cancelled out.

    ```java
    for(int num : nums){
        if(count == 0) candidate = num;
        count += (candidate == num)? 1: -1;
    }
    ```

1. [X][Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
1. [X][Missing Number](https://leetcode.com/problems/missing-number/)
1. [X][Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)
1. [X][Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)
1. [ ][Third Maximum Number](https://leetcode.com/problems/third-maximum-number/)
1. [ ][Assign Cookies](https://leetcode.com/problems/assign-cookies/)
1. [ ][Array Partition I](https://leetcode.com/problems/array-partition-i/)
1. [ ][Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/)
1. [ ][Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)
1. [ ][Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/)
1. [ ][Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle/)
1. [ ][Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)
1. [ ][Matrix Cells in Distance Order](https://leetcode.com/problems/matrix-cells-in-distance-order/)
1. [ ][Height Checker](https://leetcode.com/problems/height-checker/)
1. [ ][Relative Sort Array](https://leetcode.com/problems/relative-sort-array/)
1. [ ][Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference/)
1. [ ][Rank Transform of an Array](https://leetcode.com/problems/rank-transform-of-an-array/)
1. [ ][Sort Integers by The Number of 1 Bits](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/)
1. [ ][How Many Numbers Are Smaller Than the Current Number](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)
1. [ ][Maximum Product of Two Elements in an Array](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)
1. [ ][Average Salary Excluding the Minimum and Maximum Salary](https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/)
1. [ ][Make Two Arrays Equal by Reversing Sub-arrays](https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/)
1. [ ][Can Make Arithmetic Progression From Sequence](https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/)
1. [ ][Sort Array by Increasing Frequency](https://leetcode.com/problems/sort-array-by-increasing-frequency/)
1. [ ][Special Array With X Elements Greater Than or Equal X](https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/)
1. [ ][Find all numbers disappeared in an array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
1. [ ][Set Mismatch](https://leetcode.com/problems/set-mismatch/)
1. [ ][2Sum](https://leetcode.com/problems/two-sum/)

## Medium
1. [ ][3Sum](https://leetcode.com/problems/3sum/)
1. [ ][3Sum Closest](https://leetcode.com/problems/3sum-closest/)
1. [ ][4Sum](https://leetcode.com/problems/4sum/)
1. [ ][Group Anagrams](https://leetcode.com/problems/group-anagrams/)
1. [ ][Merge Intervals](https://leetcode.com/problems/merge-intervals/)
1. [ ][Sort Colors](https://leetcode.com/problems/sort-colors/)
1. [ ][Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/)
1. [ ][Sort List](https://leetcode.com/problems/sort-list/)
1. [ ][Largest Number](https://leetcode.com/problems/largest-number/)
1. [ ][Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
1. [ ][Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)
1. [ ][Find all Duplicates in an array](https://leetcode.com/problems/find-all-duplicates-in-an-array/)

## Hard
1. [ ][First missing Positive](https://leetcode.com/problems/first-missing-positive/)