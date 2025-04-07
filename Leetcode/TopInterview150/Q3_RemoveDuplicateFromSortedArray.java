public class Q3_RemoveDuplicateFromSortedArray {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        int[] nums = {0,0,1,2,2,2,2,3};

        int k = removeDuplicatesLC(nums);

        for(int i = 0; i < k; i++){
            System.out.print(nums[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        int max = nums[nums.length - 1];
        int i = 0;
        int j = 1;

        while(true){
            if(nums[i] == max){
                break;
            }
            if(nums[i] == nums[j]){
                j++;
                continue;
            }
            i++;
            nums[i] = nums[j];
        }

        return i + 1;
    }
    //Simple Solution
    public static int removeDuplicatesLC(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
