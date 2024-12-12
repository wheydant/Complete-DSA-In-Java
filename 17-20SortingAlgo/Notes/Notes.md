# Sorting Algorithm

## Stable Algorithm
![Stable Algorithm](image.png)

### Which sorting algorithms are stable?
Some Sorting Algorithms are stable by nature, such as ***Bubble Sort, Insertion Sort, Merge Sort, Count Sort,*** etc. Other non-comparison-based sorts such as Counting Sort maintain stability by ensuring that the Sorted Array is filled in reverse order so that elements with equivalent keys have the same relative position. Some sorts such as Radix Sort depend on another sort, with the only requirement that the other sort should be stable.

### Which sorting algorithms are unstable? 
***Selection Sort, Quick Sort, Heap Sort etc.***, can be made stable by also taking the position of the elements into consideration. This change may be done in a way that does not compromise a lot on the performance and takes some extra space, possibly θ(n) .

## Bubble Sort

### Explaination

Bubble sort is a simple sorting algorithm that repeatedly compares adjacent elements in a list, swapping them if they are in the wrong order, until the entire list is sorted, essentially causing larger elements to "bubble up" at the end after each itteration.

### Time Complexity

1. Best Case Time Complexity Analysis of Bubble Sort: O(N)
    
    The best case occurs when the array is already sorted. So the number of comparisons required is N-1 and the number of swaps required = 0. Hence the best case complexity is O(N).

2. Worst Case Time Complexity Analysis of Bubble Sort: O(N2)
    
    The worst-case condition for bubble sort occurs when elements of the array are arranged in decreasing order.In the worst case, the total number of iterations or passes required to sort a given array is (N-1). where ‘N’ is the number of elements present in the array.

3. Average Case Time Complexity Analysis of Bubble Sort: O(N2)
    
    The number of comparisons is constant in Bubble Sort. So in average case, there are O(N2) comparisons. This is because irrespective of the arrangement of elements, the number of comparisons C(N) is same.

> Stable Algorithm

## Code
```Java
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return arr;
```

## Selection Sort

### Explaination
Selection sort repeatedly finds the smallest/largest element in an unsorted part of an array and swaps it with the first/last element of that unsorted part, gradually building a sorted section until the entire array is sorted.

### Time Complexity Analysis of Selection Sort:
1. Best-case: O(n2), best case occurs when the array is already sorted. (where n is the number of integers in an array)
2. Average-case: O(n2), the average case arises when the elements of the array are in a disordered or random order, without a clear ascending or descending pattern.
3. Worst-case: O(n2), The worst-case scenario arises when we need to sort an array in ascending order, but the array is initially in descending order.

> Unstable ALgorithm

### Code
```Java
        for(int i = 0; i < arr.length; i++){
            int max = 0;
            for(int j = 1; j < arr.length - i; j ++){
                if(arr[max] < arr[j]){
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
```

## Insertion Sort

### Explaination
Insertion sort is a sorting algorithm that iteratively builds a sorted list by taking one element at a time, comparing it to the already sorted portion, and inserting it in the correct position within that sorted section.

### Time Complexity
1. Best case: O(n) , If the list is already sorted, where n is the number of elements in the list.
2. Average case: O(n^2 ) , If the list is randomly ordered
3. Worst case: O(n^2 ) , If the list is in reverse order

>Stable Algorithm

### Code
```Java
        for(int i = 0; i < arr.length - 1; i++){
            //Make LHS as sorted array
           for(int j = i + 1; j > 0; j--){
            if(arr[j] < arr[j - 1]){
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }else{
                break;
            }
           }
        }
        return arr;
```
## Cyclic Sort

### Explaination
Cyclic sort is an in-place sorting algorithm that iteratively places each element in its correct position by repeatedly swapping elements within a cycle formed by mismatched values, effectively "rotating" elements until the array is sorted, assuming the **elements are within a known range and unique**.

> ***Note:*** Whenever Question states that number exist between 1 to N always check if cyclic sort can be used.

### Time Complexity

1. Worst Case : O(n) 
2. Average Case: O(n) 
3. Best Case : O(n)

>Unstable Algorithm

### Code
```Java
        int i = 0;
        while(i < arr.length){
            if(arr[i] != i + 1){
                int realPosOfi = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[realPosOfi];
                arr[realPosOfi] = temp;
            }else{
                i++;
            }
        }
        return arr;
```