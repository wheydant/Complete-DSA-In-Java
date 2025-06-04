package Striver.TwoPointerAndSlidingWindow.LeetCode;

public class MaximumPointsYouCanObtainFromCards{
    //TLE
    public static int maxScore(int[] cardPoints, int k) {
        int maxSum = Integer.MIN_VALUE;
        int leftCount = k;
        int rightCount = 0;
        while(leftCount >= 0 && rightCount <= k){
            int currSum = 0;
            for(int i = 0; i < leftCount; i++){
                currSum += cardPoints[i];
            }
            for(int i = cardPoints.length - rightCount; i < cardPoints.length; i++){
                currSum += cardPoints[i];
            }

            maxSum = Math.max(maxSum, currSum);
            leftCount--;
            rightCount++;
        }
        return maxSum;
    }
    //TC - O(2*k)
    public static int maxScoreSW(int[] cardPoints, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        int maxSum = sum;
        int rightCounter = cardPoints.length - 1;
        for(int i = k - 1; i>=0; i--){
            sum -= cardPoints[i];
            sum += cardPoints[rightCounter--];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        System.out.println(maxScoreSW(arr, k));
    }
}