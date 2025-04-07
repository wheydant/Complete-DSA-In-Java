public class Q2_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int stopper = removeElement(nums, val);

        for (int i = 0; i < stopper; i++) {
            System.out.println(nums[i]);   
        }
    }
    public static int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            while(nums[start] != val){
                start++;
            }
            while(nums[end] == val){
                end--;
            }
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        return start;
    }
}
