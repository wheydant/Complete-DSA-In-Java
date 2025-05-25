
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerAndBigDecimalDemo {
    static class Factorial {
        static BigInteger fact(int num){
            BigInteger ans = new BigInteger("1");

            for(int i = 2; i <= num; i++){
                //As .multiply also accepts BigInteger
                ans = ans.multiply(BigInteger.valueOf(i));
            }

            return ans;
        }
    }
    public static void BD(){
        double x = 0.03;
        double y = 0.04;
        double a = y - x;
        System.out.println(a);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal A = Y.subtract(X);

        System.out.println(A);

        BigDecimal L = new BigDecimal("12345.6789");
        BigDecimal M = new BigDecimal("123.456789");

        System.out.println(L.add(M));
        System.out.println(M.pow(2));
        System.out.println(L.negate());

        BigDecimal con = BigDecimal.ONE;
        System.out.println(con);

    }
    public static void main(String[] args) {
        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(33);
        //valueOf is static which accepts long
        BigInteger B = BigInteger.valueOf(123456789);
        //Huge numbers can be made by passing them as string in constructor
        BigInteger C = new BigInteger("123456789123456789");

        BigInteger D = BigInteger.TEN;

        BigInteger S = A.add(B);

        //Throws error
        // if(A < B){
        if(A.compareTo(B) > 0){
        }

        BigInteger M = C.multiply(B);
        System.out.println(M);

        System.out.println(S);

        Factorial f = new Factorial();
        System.out.println(f.fact(100));

        BD(); 
    }
}
