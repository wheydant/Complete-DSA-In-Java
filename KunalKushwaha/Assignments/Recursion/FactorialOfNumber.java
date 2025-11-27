package KunalKushwaha.Assignments.Recursion;

public class FactorialOfNumber{
    static int factorialOfNumber(int n){
        if(n <= 1) return 1;
        return n * factorialOfNumber(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(factorialOfNumber(3));
    }
}