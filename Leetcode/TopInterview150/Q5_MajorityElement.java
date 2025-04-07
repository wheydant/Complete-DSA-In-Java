
import java.util.Arrays;

public class Q5_MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        nums = new int[]{3, -2, 3};
        // System.out.println(worstSolmajorityElement(nums));
        System.out.println(majorityElement(nums));
    }
    public static int worstSolmajorityElement(int[] nums) {
        Arrays.sort(nums);
        int maxNo = nums[nums.length - 1];
        int[] count = new int[maxNo + 1];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        int max = Integer.MIN_VALUE;
        maxNo = 0;
        for(int i = 0; i < count.length; i++){
            if(count[i] > max){
                max = count[i];
                maxNo = i;
            }
        }
        return maxNo;
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int maxCount = 1;
        int currCount = 0;
        int result = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                currCount++;
            }else{
                currCount = 0;
            }

            if(currCount >= maxCount){
                maxCount = currCount;
                //i - 1 works coz anyhow we are comparing with previous element. 
                result = nums[i - 1];
            }
        }

        return result;
    }
    //As it is specified that element occupies more than n/2 space
    public int majorityElementLC1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
    //Moore Voting Algorithm - The intuition behind the Moore's Voting Algorithm is based on the fact that if there is a majority element in an array, it will always remain in the lead, even after encountering other elements.
    public int majorityElementLC2(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}
