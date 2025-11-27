package KunalKushwaha.Assignments.Recursion;

public class SumOfNaturalNumber{
    static int sumOf(int n){
        if(n == 0) return 0;
        return n + sumOf(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(sumOf(5));
    }
}