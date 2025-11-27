package KunalKushwaha.Assignments.String;

public class CountNumberOfHomogenousSubstrings {
    public int countHomogenous(String s) {
        long count = 1, res = 0;
        int n = s.length();
        for(int i = 1; i < n; i++){
            char c = s.charAt(i);
            if(c == s.charAt(i - 1)){
                count++;
            }
            else {
                // Perform modulo operation to avoid overflow
                res = (res + (count*(count+1))/2) % 1_000_000_007;
                count = 1;
            }
        }
        // Add the remaining count and perform modulo operation
        res = (res + (count*(count+1))/2) % 1_000_000_007;
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(new CountNumberOfHomogenousSubstrings().countHomogenous("xy"));
    }
}