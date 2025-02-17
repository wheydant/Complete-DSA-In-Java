public class Palindrome{
    public static boolean isPalindrome(String str){

        if(str == null || str.length() == 0){
            return true;
        }

        int start = 0;
        int end = str.length() - 1;
        str = str.toLowerCase();

        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        for(int i = 0; i < str.length() / 2; i++){
            start = str.charAt(i);
            end = str.charAt(str.length() - 1 - i);

            if(start != end){
                return false;
            }
        }

        return true;
    } 
    public static void main(String[] args) {
        String str = "aaabbcaa";
        System.out.println(isPalindrome(str));
    }
}