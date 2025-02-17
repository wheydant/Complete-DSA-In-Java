public class Fibonacci{
    public static int fibo(int n){
        if(n < 2){
            return n;
        } 
        return fibo(n - 1) + fibo(n - 2);
    }

    public static int goldenFormulaFibo(int n){
        int ans = (int)((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n))/Math.sqrt(5));

        //Can Ignore less dominating term

        ans = (int)((Math.pow(((1 + Math.sqrt(5)) / 2), n))/Math.sqrt(5));

        return ans;
    }
    public static void main(String[] args) {
        // System.out.println("Hello");
        System.out.println("nth term is : "+ goldenFormulaFibo(50));
    }
}