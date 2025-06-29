package KunalKushwaha.Assignments.Searching;

public class MaximumValueAtAGivenIndexInABoundedArray{
    public int maxValue(int n, int index, int maxSum) {
        int emptyR = n - index - 1;
        int emptyL = index;

        int high = maxSum, low = 1;
        long res = 0;

        while(low <= high){
            int mid = (high - low)/2 + low;
            
            // As mid needs to be inserted at the index el is next number from which AP starts
            long leftSum = 0, rightSum = 0, el = mid - 1;

            if(emptyR <= el){
                //Remove Extra GP n(n + 1)/2
                rightSum = (el*(el + 1))/2 - ((el - emptyR)*(el - emptyR + 1))/2;
            }else{
                //Add ones
                rightSum = (el*(el + 1))/2 + (emptyR - el);
            }

            if(emptyL <= el){
                //Remove Extra GP n(n + 1)/2
                leftSum = (el*(el + 1))/2 - ((el - emptyL)*(el - emptyL + 1))/2;
            }else{
                //Add ones
                leftSum = (el*(el + 1))/2 + (emptyL - el);
            }

            long sum = leftSum + mid + rightSum;

            if(sum <= maxSum){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return (int)res;
    }
}