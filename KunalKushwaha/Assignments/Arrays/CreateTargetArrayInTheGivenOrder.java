
import java.util.Arrays;

public class CreateTargetArrayInTheGivenOrder {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] targetArray = new int[nums.length];
        Arrays.fill(targetArray, 101);
        
        for(int i = 0; i < nums.length; i++){
            if(targetArray[index[i]] == 101){
                targetArray[index[i]] = nums[i];
            }else{
                pushForward(targetArray, index[i], nums[i]);
            }
        }

        return targetArray;
    }
    private static void pushForward(int[] targetArray, int index, int value) {
        int tempStore = 0;
        int tempInsert = value;
        for(int i = index; i < targetArray.length; i++){
            tempStore = targetArray[i];
            targetArray[i] = tempInsert;
            tempInsert = tempStore;
        }
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }
}
