package LeetCodeBS;
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchInRotatedSortedArray {
    public static int findBreak(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            int mid = start + (end - start)/2;
            if(mid < nums.length){
                if(nums[mid] > nums[mid+1]){
                    return mid;
                }else if(nums[start] < nums[mid]){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }
        }

        return nums.length - 1;
    }
    public static int findBreakInRepeats(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            int mid = start + (end - start)/2;
            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(start < mid && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }else if(nums[mid] == nums[start] && nums[mid] == nums[end]){
                if(nums[start] > nums[start + 1]){
                    return start;
                }
                start++;
                if(nums[end] < nums[end - 1]){
                    return end - 1;
                }
                end--;
            }

            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return nums.length - 1;
    }
    public static int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public static int search(int[] nums, int target, boolean repeat) {
        int breakPoint;
        if(repeat == false){
            breakPoint = findBreak(nums);
            
        }else{
            breakPoint = findBreakInRepeats(nums);
        }
        int returnVal = binarySearch(nums, 0, breakPoint, target);
        if(returnVal != -1){
            return returnVal;
        }
        return binarySearch(nums, breakPoint + 1, nums.length - 1, target);
    }
    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(search(nums, 1, false));

        int[] numsRep = {2,2,3,2};
        System.out.println(search(numsRep, 2, true));
    }
}
