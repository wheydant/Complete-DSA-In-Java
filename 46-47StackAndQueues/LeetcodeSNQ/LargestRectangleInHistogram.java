import java.util.Stack;

public class LargestRectangleInHistogram {
    //Throws TLE
    public static int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int leftArea = heights[i]*leftLength(i, heights);
            int rightArea = heights[i]*rightLength(i, heights);

            int area = leftArea + heights[i] + rightArea;

            System.out.println("Area for " + heights[i] + " leftArea " + leftArea + " rightArea " + rightArea+ " area "+area);

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int leftLength(int i, int[] heights){
        int length = 0;
        for(int j = i - 1; j >= 0; j--){
            if(heights[i] <= heights[j]){
                length++;
            }else{
                break;
            }
        }
        return length;
    }

    private static int rightLength(int i, int[] heights){
        int length = 0;
        for(int j = i + 1; j < heights.length; j++){
            if(heights[i] <= heights[j]){
                length++;
            }else{
                break;
            }
        }
        return length;
    }
    //It stores a stack which has all the ascending indexes and calculates area using that refer video.
    public static int largestRectangleAreaKK(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }
        int i = heights.length;
        while(!stack.isEmpty()){
            max = getMax(heights, stack, max, i);
        }
        return max;
    }

    private static int getMax(int[] arr, Stack<Integer> stack, int max, int i){
        int area;
        int popped = stack.pop();
        if(stack.isEmpty()){
            area = arr[popped]*i;
        }else{
            area = arr[popped]*(i - 1 - stack.peek());
        }
        return Math.max(max, area);
    }
    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));

    }
}
