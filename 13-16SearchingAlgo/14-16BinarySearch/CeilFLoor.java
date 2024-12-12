public class CeilFLoor {
    public static int ceilNumber(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = end - (end - start)/2;
            //System.out.println("Entered : "+start+" "+end);
            int middleNum = nums[mid];
            if(middleNum < target){
                start = mid + 1;
            }else if(middleNum > target){
                end = mid - 1;
            }else{
                return nums[mid];
            }
        }
        if(start >= nums.length || target > nums[nums.length - 1]){
            return Integer.MAX_VALUE;
        }
        return nums[start];
    }
    public static int floorNumber(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = end - (end - start)/2;
            //System.out.println("Entered : "+start+" "+end);
            int middleNum = nums[mid];
            if(middleNum < target){
                start = mid + 1;
            }else if(middleNum > target){
                end = mid - 1;
            }else{
                return nums[mid];
            }
        }
        if(end < 0 || target < nums[0]){
            return Integer.MIN_VALUE;
        }
        return nums[end];
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        int target = 8;
        System.out.println("Ceil of "+target +" "+ ceilNumber(nums, target));
        System.out.println("Floor of "+target +" "+ floorNumber(nums, target));
        
    }
}
