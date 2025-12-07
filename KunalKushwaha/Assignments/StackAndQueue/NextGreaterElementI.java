package KunalKushwaha.Assignments.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        for(int i = 0; i < nums1.length; i++){
            boolean numFound = false;
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] != nums2[j] && !numFound) continue;
                else if(nums1[i] == nums2[j]) numFound = true;
                else{
                    if(nums1[i] < nums2[j]){
                        ans[i] = nums2[j];
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreatest = new int[10001];
        Stack<Integer> stack = new Stack<>();

        for(int i = nums2.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() < nums2[i]) stack.pop();

            nextGreatest[nums2[i]] = (stack.isEmpty())? -1 : stack.peek();

            stack.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++){
            nums1[i] = nextGreatest[nums1[i]];
        }

        return nums1;
    }
}
