class LongestValidParanthesis {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if(left == right)
                max = Math.max(max, left*2);
            else if(right > left)
                left = right = 0;
        }

        //Catch it fails for (() -> as in this traversal left is 2 right is 1 no solution found, so traverse it in reverse order
        left = right = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if(left == right)
                max = Math.max(max, left*2);
            else if(right < left)
                left = right = 0;
        }
        return max;
    }
}