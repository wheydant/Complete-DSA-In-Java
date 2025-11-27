package KunalKushwaha.Assignments.Recursion;

public class Print1toN{
    String helper(int n){
        if(n == 0) return "";
        return helper(n - 1) + " " + n;
    }
    public void printNos(int n) {
        // Code here
        String S = helper(n);
        System.out.println(S.subSequence(1, S.length()));
    }
    public static void main(String[] args) {
        new Print1toN().printNos(10);
    }
}