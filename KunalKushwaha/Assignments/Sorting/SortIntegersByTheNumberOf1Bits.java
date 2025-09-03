package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;
import java.util.Comparator;

// Test class to demonstrate the solution
class SortIntegersByTheNumberOf1Bits {
    //My Solution
    int countBit(int num){
        if(num == 0) return 0;
        int lastBit = num & 1;
        num = num>>1;
        return lastBit + countBit(num);
    }
    public int[] sortByBits(int[] arr) {
        // Convert to Integer[] for custom comparator
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArr, (a, b) -> {
            int bitCountA = countBit(a);
            int bitCountB = countBit(b);
            if (bitCountA == bitCountB) {
                return a - b; // sort by value if bit counts equal
            }
            return bitCountA - bitCountB; // sort by bit count
        });

        // Convert back to int[]
        return Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
    }
    // Claude code
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(solution.sortByBits(arr1.clone())));
        // Expected: [0, 1, 2, 4, 8, 3, 5, 6, 7]
        
        // Test case 2
        int[] arr2 = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        System.out.println("\nInput: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(solution.sortByBits(arr2.clone())));
        // All have 1 bit, so sorted by value
        
        // Test case 3
        int[] arr3 = {10, 100, 1000, 10000};
        System.out.println("\nInput: " + Arrays.toString(arr3));
        System.out.println("Output: " + Arrays.toString(solution.sortByBits(arr3.clone())));
    }
}

class Solution {
    // Method 1: Using built-in Integer.bitCount() - Most efficient
    public int[] sortByBits(int[] arr) {
        // Convert to Integer array for sorting with custom comparator
        Integer[] integerArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArr[i] = arr[i];
        }
        
        Arrays.sort(integerArr, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            if (bitCountA == bitCountB) {
                return Integer.compare(a, b);
            }
            return Integer.compare(bitCountA, bitCountB);
        });
        
        // Convert back to int array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = integerArr[i];
        }
        return arr;
    }
    
    // Alternative method using Comparator interface (Java 7 compatible)
    public int[] sortByBitsCompatible(int[] arr) {
        Integer[] integerArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArr[i] = arr[i];
        }
        
        Arrays.sort(integerArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int bitCountA = Integer.bitCount(a);
                int bitCountB = Integer.bitCount(b);
                if (bitCountA == bitCountB) {
                    return Integer.compare(a, b);
                }
                return Integer.compare(bitCountA, bitCountB);
            }
        });
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = integerArr[i];
        }
        return arr;
    }
    
    // Method 2: Your original recursive approach (fixed)
    public int[] sortByBitsRecursive(int[] arr) {
        Arrays.sort(arr, (a, b) -> {
            int bitCountA = countBit(a);
            int bitCountB = countBit(b);
            if (bitCountA == bitCountB) {
                return Integer.compare(a, b); // Handle potential overflow
            }
            return Integer.compare(bitCountA, bitCountB);
        });
        return arr;
    }
    
    // Your recursive bit counting method (works correctly)
    int countBit(int num) {
        if (num == 0) return 0;
        int lastBit = num & 1;
        num = num >> 1;
        return lastBit + countBit(num);
    }
    
    // Method 3: Iterative bit counting (more efficient than recursion)
    int countBitIterative(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
    
    // Method 4: Brian Kernighan's algorithm (most efficient custom implementation)
    int countBitKernighan(int num) {
        int count = 0;
        while (num != 0) {
            num &= (num - 1); // Removes the rightmost set bit
            count++;
        }
        return count;
    }
}