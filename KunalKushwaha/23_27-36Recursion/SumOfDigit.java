public class SumOfDigit {
    public static void main(String[] args) {
        System.out.println(sumOfDigit(1234));
        System.out.println(productOfDigit(1234));
    }
    static int sumOfDigit(int n){
        if(n == 0){
            return 0;
        }
        return (n%10) + sumOfDigit(n/10);
    }
    static int productOfDigit(int n){
        if(n == 1){
            return 1;
        }
        return (n%10) * sumOfDigit(n/10);
    }
}
