public class Q4_RemoveDuplicatesFromSortedArray2 {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};

        int k = removeDuplicates(nums);

        for(int i = 0; i < k; i++){
            System.out.print(nums[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
