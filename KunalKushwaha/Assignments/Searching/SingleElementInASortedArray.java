package KunalKushwaha.Assignments.Searching;
/*
In a sorted array where every element appears exactly twice except for one, the trick lies in observing the index pairing pattern.

Normally:

Elements before the single element will have pairs like: (even, odd)
After the single element, the pattern breaks: the first occurrence will be at an odd index.
This property allows us to apply binary search for a logarithmic solution.
*/
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
       int left = 0 ;
       int right = nums.length - 1;

       while(left < right){
            int mid = left + (right - left ) / 2;
            //Ideally it should be 0 and 1 the same
            if(mid % 2 == 1){
                //Thus if mid is odd move to prev even number
                mid--;
            }
            //If its equal then all the elements to left are double
            if(nums[mid] == nums[mid + 1]){
                //+2 coz mid was actually current mid + 1;
                left = mid + 2;
            }else{
                //We have found decripency thus ans lies from mid to left
                right = mid;
            }
       }
       return nums[left];
    }
}
