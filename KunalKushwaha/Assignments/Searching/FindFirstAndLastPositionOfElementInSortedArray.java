package KunalKushwaha.Assignments.Searching;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int getStartRange(int[] nums, int mid, int target){
        int start = mid;
        while(mid >= 0 && nums[mid] == target){
            start = mid;
            mid--;
        }
        return start;
    }
    public int getEndRange(int[] nums,int mid , int target){
        int end = mid;
        while(mid < nums.length && nums[mid] == target){
            end = mid;
            mid++;
        }
        return end;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] returnVal = {-1, -1};
        returnVal[0] = modifiedBinarySearch(nums, target, true);
        returnVal[1] = modifiedBinarySearch(nums, target, false);

        return returnVal;
        // int start = 0;
        // int end = nums.length - 1;
        // while(start <= end){
        //     int mid = end - (end - start)/2;
        //     if(nums[mid] == target){
        //         returnVal[0] = getStartRange(nums, mid, target);
        //         returnVal[1] = getEndRange(nums, mid, target);
        //         break;
        //     }else if(nums[mid] > target){
        //         end = mid - 1;
        //     }else{
        //         start = mid + 1;
        //     }
        // }
        // return returnVal;
    }
    //LogN
    public int modifiedBinarySearch(int[] nums, int target, boolean isFirstElement){
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
                //When found store it 
                index = mid;
                //If we want to find firstElement then move the window to left to seek for more better solution in first 
                if(isFirstElement){
                    end = mid - 1;
                }else{
                    //else window to right
                    start = mid + 1;
                }
            }
        }
        return index;
    }
}
