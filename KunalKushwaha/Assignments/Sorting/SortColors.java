package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;

public class SortColors {
    //O(2n)
    public void sortColors(int[] nums) {
        int z = 0, o = 0, t = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                z++;
            else if(nums[i] == 1)
                o++;
            else
                t++;
        }
        for(int i = 0; i < nums.length; i++){
            if(z-- > 0)
                nums[i] = 0;
            else if(o-- > 0)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
    // Since red < white, the index red was already processed earlier. So the element at nums[red] could only be 0 or 1 (never 2). After swapping, nums[white] will hold either 0 or 1.
    public void sortColorsOptimum(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;
        
        while (white <= blue) {
            if (nums[white] == 0) {
                int temp = nums[white];
                nums[white] = nums[red];
                nums[red] = temp;
                red++;
                white++;
            } else if (nums[white] == 1) {
                white++;
            } else {
                int temp = nums[white];
                nums[white] = nums[blue];
                nums[blue] = temp;
                blue--;
            }
        }
    }
  public static void main(String[] args) {
    SortColors q = new SortColors();
    int[] nums = {2, 0, 2, 1,1,0};
    q.sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }
}
