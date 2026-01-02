# Videos
- [Bubble Sort](https://youtu.be/F5MZyqRp_IM)
- [Selection Sort](https://youtu.be/Nd4SCCIHFWk)
- [Insertion Sort](https://youtu.be/By_5-RRqVeE)
- [Cycle Sort](https://www.youtube.com/watch?v=JfinxytTYFQ&list=RDCMUCBGOUQHNNtNGcGzVq5rIXjw&start_radio=1&rv=JfinxytTYFQ&t=2)
- [Merge Sort](https://youtu.be/iKGAgWdgoRk)
- [Quick Sort](https://youtu.be/Z8svOqamag8)

# Questions

Total - 43

Done - 43

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
1. [X][Third Maximum Number](https://leetcode.com/problems/third-maximum-number/)
1. [X][Assign Cookies](https://leetcode.com/problems/assign-cookies/)
1. [X][Array Partition I](https://leetcode.com/problems/array-partition-i/)
1. [X][Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/)

    ```java
        // Option 1: Last three elements
        int prod1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        // Option 2: Two smallest and the largest
        int prod2 = nums[0] * nums[1] * nums[n - 1];
    ```

1. [X][Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)
1. [X][Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/)
1. [X][Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle/)
    `If the side of a triangle are a,b,c then a+b>c for the triangle to be formed`
1. [X][Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)
1. [X][Matrix Cells in Distance Order](https://leetcode.com/problems/matrix-cells-in-distance-order/)
    >**Note :** Index array of 2D matrix and how to use comparator to find the distance and using abs as | | mod.
    ```java
        int i = 0;
        //Index array
        while(i < totalElements){
            for(int row = 0; row < rows; row++){
                for(int col = 0; col < cols; col++){
                    int[] index = new int[2];
                    index[0] = row;
                    index[1] = col;
                    matrix[i++] = index;
                }
            }
        }
        //Comparator and also Math.abs as | |
        Arrays.sort(matrix, (a, b) -> (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)) - (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter)));
    ```
1. [X][Height Checker](https://leetcode.com/problems/height-checker/)
1. [X][Relative Sort Array](https://leetcode.com/problems/relative-sort-array/)

    >**Note :** Annoying question definitely not easy.

1. [X][Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference/)

    Sort the array to get proper ascending pair. Convert Array to List.
    ```java
        //Converting Array to List
        List<Integer> minDiffPair = Arrays.asList(arr[i - 1], arr[i]);
        minDiffList.add(minDiffPair);
    ```
1. [X][Rank Transform of an Array](https://leetcode.com/problems/rank-transform-of-an-array/)

    `int[] utilsArr = Arrays.copyOf(arr, n);` copyOf always need array and length.

1. [X][Sort Integers by The Number of 1 Bits](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/)

    >**Note :** For comparator (a, b) can't be primitive datatype so we need to convert int[] to Integer[]. It is done using `Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);` .boxed() converts integer to Integer. Integer[]::new it is a construction reference. Returned as int[] using `return Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();`.

1. [X][How Many Numbers Are Smaller Than the Current Number](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)

    Count for all the 100 numbers crazy approach.
    `for (int i = 1 ; i <= 100; i++) count[i] += count[i-1];`

1. [X][Maximum Product of Two Elements in an Array](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)

    Either sort array O(nlogn) or find max and secondMax O(n).

1. [X][Average Salary Excluding the Minimum and Maximum Salary](https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/)
1. [X][Make Two Arrays Equal by Reversing Sub-arrays](https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/)
1. [X][Can Make Arithmetic Progression From Sequence](https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/)
1. [X][Sort Array by Increasing Frequency](https://leetcode.com/problems/sort-array-by-increasing-frequency/)
    >**Note :** Two solutions
1. [X][Special Array With X Elements Greater Than or Equal X](https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/)
1. [X][Find all numbers disappeared in an array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
1. [X][Set Mismatch](https://leetcode.com/problems/set-mismatch/)
1. [X][2Sum](https://leetcode.com/problems/two-sum/)

## Medium
1. [X][3Sum](https://leetcode.com/problems/3sum/)
1. [X][3Sum Closest](https://leetcode.com/problems/3sum-closest/)
1. [X][4Sum](https://leetcode.com/problems/4sum/)
1. [X][Group Anagrams](https://leetcode.com/problems/group-anagrams/)
1. [X][Merge Intervals](https://leetcode.com/problems/merge-intervals/)
    >**Note :** Coveting List<int[]> to int[][] `return ans.toArray(new int[ans.size()][]);`
1. [X][Sort Colors](https://leetcode.com/problems/sort-colors/)
1. [O][Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/)
1. [O][Sort List](https://leetcode.com/problems/sort-list/)
1. [ ][Largest Number](https://leetcode.com/problems/largest-number/)

    [Link](https://www.youtube.com/watch?v=WDx6Y4i4xJ8&ab_channel=NeetCode)
    
    Greedy Largest number at MSB, clash between 3 and 30. Easiest way to compare 330 to 303. Or break the data into small problem where we compare both ways.

    ```java
        //Comparing String rather than int is easier
        for(int i = 0; i < n; i++)sortedNums[i] = nums[i] + "";

        //Great just associative rule
        Arrays.sort(sortedNums, (a, b) -> (b + a).compareTo(a + b));

        //Key critical case
        if(sortedNums[0].equals("0")) return "0";
    ```

1. [X][Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

    Solutions - 
    - Sort
    - Map
    - MinHeap
    - Quick select => Quickselect is an in-place selection algorithm that finds the k-th smallest (or largest) element without fully sorting the array. It’s the selection cousin of Quicksort: same partition idea, but it only explores the side that could contain the answer—so it’s average O(n) time, worst-case O(n²), and O(1) extra space.

1. [X][Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)
1. [X][Find all Duplicates in an array](https://leetcode.com/problems/find-all-duplicates-in-an-array/)

## Hard
1. [ ][First missing Positive](https://leetcode.com/problems/first-missing-positive/)

Find the Duplicate Number, Find all Duplicates in an array, First missing Positive all three question follow similar pattern where we swap the number to its actual position then traverse through the array to check if the index matches with the desired number.

First Missing Positive takes it to next level as first positive number is 1 which needs to present at 0th index to we traverse the array and just assign the positive numbers to their desire position and traverse the array to keep on checking which numbers are not present.

```java
    public void swap(int[] arr, int posOne, int posTwo){
        int temp = arr[posOne];
        arr[posOne] = arr[posTwo];
        arr[posTwo] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctPos = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[correctPos] != nums[i]){
                swap(nums, correctPos, i);
            }else{
                i++;
            }
        }
        // System.out.println(Arrays.toString(nums));
        for(i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        //Smart return if input array is 1,2,3
        return nums.length + 1;
    }
```