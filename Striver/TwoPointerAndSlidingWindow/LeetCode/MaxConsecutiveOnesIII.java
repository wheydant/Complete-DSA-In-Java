package Striver.TwoPointerAndSlidingWindow.LeetCode;

public class MaxConsecutiveOnesIII {
    //TC = O(n^2)
    public static int longestOnes(int[] nums, int k) {
        int longestOnes = 0;
        for(int i = 0; i < nums.length; i++){
            int tempK = k;
            int currentOnes = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0){
                    tempK--;
                }
                if(tempK < 0)break;
                currentOnes++;
            }
            if(currentOnes > longestOnes){
                System.out.println(i + " " + i + currentOnes);
                longestOnes = currentOnes;
            }
        }
        return longestOnes;
    }
    // TC = O(n) at max O(2n) 2nd while loop causes 2n in worst cases to remove that.
    public static int longestOnesSW(int[] nums, int k) {
        int longestOnes = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0)k--;
            while(k < 0){
                if(nums[left] == 0)k++;
                left++;
            }
            longestOnes = Math.max(right - left + 1, longestOnes);
        }
        return longestOnes;
    }
    //O(n)
    public static int longestOnesSWOptimize(int[] nums, int k) {
        int maxLength = 0;
        int left = 0, right = 0, zeros = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                zeros++;
            }

            if(zeros > k){
                if(nums[left] == 0)zeros--;
                left++;
            }
            if(zeros <= k){
                maxLength = Math.max(right - left + 1, maxLength); 
            }
            right++;
        }

        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;

        System.out.println(longestOnesSWOptimize(nums, k));
    }
}
