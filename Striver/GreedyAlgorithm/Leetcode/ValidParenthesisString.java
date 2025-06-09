package Striver.GreedyAlgorithm.Leetcode;

public class ValidParenthesisString {
    // TC - Count how many branches are formed here 3 thus O(3^n)
    // Using DP O(n^2) SC O(n^2)
    // SC - O(n)
    public static boolean checkValidString(String s) {
        return helper(s, 0, 0);
    }
    static boolean helper(String s, int index, int count){
        if(count < 0) return false;
        if(index == s.length()){
            return count == 0;
        }
        if(s.charAt(index)== '(') return helper(s, index + 1, count + 1);
        if(s.charAt(index)== ')') return helper(s, index + 1, count - 1);
        return helper(s, index + 1, count - 1) || helper(s, index + 1, count + 1) || helper(s, index + 1, count);
    }
    //Using range as an indicator if the solution is possible or not
    public static boolean checkValidStringOptimize(String s) {
        int max = 0;
        int min = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                min++;
                max++;
            }else if(s.charAt(i) == ')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }
            if(min < 0)min = 0;
            if(max < 0)return false;
        }

        return min == 0;
    }
    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidStringOptimize(s));
    }
}
