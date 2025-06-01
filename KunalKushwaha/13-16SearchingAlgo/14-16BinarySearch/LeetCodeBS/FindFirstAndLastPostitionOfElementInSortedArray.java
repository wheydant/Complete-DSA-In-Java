package LeetCodeBS;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1457944791/

import java.util.Arrays;

public class FindFirstAndLastPostitionOfElementInSortedArray {
    public static int getStartRange(int[] nums, int mid, int target){
            int start = mid;
            while(mid >= 0 && nums[mid] == target){
                start = mid;
                mid--;
            }
            return start;
        }
        public static int getEndRange(int[] nums,int mid , int target){
                    int end = mid;
                    while(mid < nums.length && nums[mid] == target){
                        end = mid;
                        mid++;
                    }
                    return end;
                }
        public static int[] searchRangeON(int[] nums, int target) {
            int[] returnVal = {-1, -1};
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = end - (end - start)/2;
                if(nums[mid] == target){
                    returnVal[0] = getStartRange(nums, mid, target);
                    returnVal[1] = getEndRange(nums, mid, target);
                    break;
                }else if(nums[mid] > target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            return returnVal;
            //return {startRange, endRange};
        }
        public static int[] searchRangeOLogN(int[] nums, int target){
            int[] returnValue = {-1, -1};

            returnValue[0] = modifiedBinarySearch(nums, target, true);
            if(returnValue[0] != -1){
                returnValue[1] = modifiedBinarySearch(nums, target, false);
            }

            return returnValue;
        }

        public static int modifiedBinarySearch(int[] nums, int target, boolean isFirstElement){
            int index = -1;

            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = end - (end-start)/2;

                if(nums[mid] > target){
                    end = mid - 1;
                }else if(nums[mid] < target){
                    start = mid + 1;
                }else{
                    index = mid;
                    if(isFirstElement){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }
            }
            return index;
        }
        public static void main(String[] args) {
            int[] nums = {1,2,2,3,3,4};
            int target = 4;
    
            int[] output = searchRangeON(nums, target);

            System.out.println("Searching Range with O(n) : " + Arrays.toString(output));
            output = searchRangeOLogN(nums, target);

        for (int element : output) {
            System.out.println(element);   
        }
    }

}
