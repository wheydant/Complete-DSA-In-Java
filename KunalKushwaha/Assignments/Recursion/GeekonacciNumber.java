package KunalKushwaha.Assignments.Recursion;

public class GeekonacciNumber {
    static int nthGeekonacciNumber(int a, int b, int c, int n){
        if(n == 1) return a;
        if(n == 2) return b;
        if(n == 3) return c;

        return nthGeekonacciNumber(a, b, c, n - 1) + nthGeekonacciNumber(a, b, c, n - 2) + nthGeekonacciNumber(a, b, c, n - 3);
    }
    public static void main(String[] args) {
        System.out.println(nthGeekonacciNumber(1, 3, 2, 6));
    }
}
