package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] sortedNums = new String[n];

        //Comparing String rather than int is easier
        for(int i = 0; i < n; i++){
            sortedNums[i] = nums[i] + "";
        }

        //Great just associative rule
        Arrays.sort(sortedNums, (a, b) -> (b + a).compareTo(a + b));

        if(sortedNums[0].equals("0")) return "0";

        StringBuilder largest = new StringBuilder();
        for(int i = 0; i < sortedNums.length; i++){
            largest.append(sortedNums[i]);
        }
        return largest.toString();
    }
    public static void main(String[] args) {
        LargestNumber q = new LargestNumber();
        System.out.println(q.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
