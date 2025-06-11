package KunalKushwaha.Assignments.Searching;

import java.util.Arrays;

public class TwoSumII {
    //TC - O(nLogn)
    public static int[] twoSumBS(int[] numbers, int target) {
         for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1;
			int high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] + numbers[i] == target)
                    return new int[]{i + 1, mid + 1};
                else if (numbers[mid] + numbers[i] > target) 
                    high = mid - 1;
                else 
                    low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i<j)
        {
            if(numbers[i]+numbers[j]>target)
                j--;
            else if(numbers[i]+numbers[j]<target)
                i++;
            else
                return new int[]{i+1,j+1};
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSumBrute(int[] numbers, int target) {
        int[] ans = new int[2];
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length;j++){
                if(numbers[i] + numbers[j] == target){
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
