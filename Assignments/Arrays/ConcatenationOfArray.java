
import java.util.Arrays;

public class ConcatenationOfArray {
    public static int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len*2];
        for(int i = 0; i < ans.length; i++){
            ans[i] = nums[i%len];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
}
