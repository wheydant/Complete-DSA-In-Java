package KunalKushwaha.Assignments.Recursion;

public class ProductOfTwoNumber {
    static int product(int x, int y){
        if(y == 1) return x;
        return x + product(x, y - 1);
    }
    //Optimize it
    static int productOptimize(int x, int y){
        if(x < y) productOptimize(y, x);
        else if(y == 0) return 0;
        return x + productOptimize(x, y - 1);
    }
    public static void main (String[] args){
        int x = 5, y = 2;
        System.out.println(product(x, y));
        System.out.println(productOptimize(x, y)); 
    }
}
