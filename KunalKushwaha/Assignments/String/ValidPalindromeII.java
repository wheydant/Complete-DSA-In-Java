package KunalKushwaha.Assignments.String;

public class ValidPalindromeII {
    boolean isPalindrome(int left, int right, String s){
        while(left < right) if(s.charAt(left++) != s.charAt(right--)) return false;
        return true;
    }
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                // Check if skipping either character makes the string a palindrome
                return isPalindrome(left + 1, right, s) || isPalindrome(left, right - 1, s);
            }
            right--;
            left++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("cbbcc"));
    }
}
