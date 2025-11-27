package KunalKushwaha.Assignments.String;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char chLeft = (s.charAt(left) >= 'A' && s.charAt(left) <= 'Z') ? (char) (s.charAt(left) + 32) : s.charAt(left);
            char chRight = (s.charAt(right) >= 'A' && s.charAt(right) <= 'Z') ? (char) (s.charAt(right) + 32) : s.charAt(right);
            if (!Character.isLetterOrDigit(chLeft))
                left++;
            else if (!Character.isLetterOrDigit(chRight))
                right--;
            else if (chLeft == chRight) {
                left++;
                right--;
            } else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
