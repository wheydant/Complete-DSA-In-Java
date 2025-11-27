package KunalKushwaha.Assignments.Recursion;

public class BinarySearch {
    int helper(int start, int end, int[] nums, int target){
        if(start > end) return -1;
        int mid = (end - start)/2 + start;
        if(nums[mid] == target) return mid;
        if(nums[mid] < target) return helper(mid + 1, end, nums, target);
        else return helper(start, mid - 1, nums, target);
    }
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        return helper(start, end - 1, nums, target);
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{-1,0,3,5,9,12}, 13));
    }
}
