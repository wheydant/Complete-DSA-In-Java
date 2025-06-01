public class Palindrome {
    public static void main(String[] args) {
        String s = "aabbcaa";
        System.out.println(palindrome(s, 0, s.length() - 1));
    }
    static boolean palindrome(String s, int start, int end){
        if(start > end){
            return true;
        }
        if(s.charAt(start) != s.charAt(end)){
            return false;
        }
        return palindrome(s, ++start, --end);
    }
}
