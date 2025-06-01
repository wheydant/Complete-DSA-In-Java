package LeetCode;
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }
    
    public static int numberOfSteps(int num) {
        return helper(num, 0);
    }
    public static int helper(int num, int c){
        if(num == 0){
            return c;
        }
        if(num%2 == 0){
            return helper(num/2, ++c);
        }
        return helper(--num, ++c);
    }
}
