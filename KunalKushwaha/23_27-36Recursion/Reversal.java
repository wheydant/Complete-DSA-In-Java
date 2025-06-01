public class Reversal {
    static int sum = 0;
    static void reversal1(int n){
        if(n == 0){
            return;
        }
        int rem = n%10;
        sum = sum*10 + rem;
        reversal1(n/10);
    }
    public static void main(String[] args) {
        System.out.println(reversal(1234));
        System.out.println("-------------");
        reversal1(1234);
        System.out.println(sum);
        System.out.println("-------------");
        System.out.println(palindrome(1221));
    }
    static int reversal(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return reversalHelper(n, digits);
    }
    static int reversalHelper(int n, int base){
        if(n%10 == 0){
            return n;
        }
        return  (int) (n%10*Math.pow(10,base - 1) + reversalHelper(n/10, --base));
    }
    static boolean palindrome(int n){
        return n == reversal(n);
    }
}
