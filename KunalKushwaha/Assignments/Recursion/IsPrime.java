package KunalKushwaha.Assignments.Recursion;

public class IsPrime{
    static boolean helper(int n, int i){
        if(i <= 1) return true;

        if(n % i == 0) return false;

        return helper(n, i - 1);
    }
    static boolean isPrime(int n){
        return helper(n, n - 1);
    }
    public static void main(String[] args) {
        System.out.println(isPrime(12));
    }
}