package LeetCodeBS;

//35. Search Insert Position
// https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition{
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = end - (end - start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6};
        int target = 2;

        System.out.println(searchInsert(nums, target));
        
    }
}