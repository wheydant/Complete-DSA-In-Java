public class PowerOfTwo {
    public static void main(String[] args) {
        int num = 8;

        System.out.println(isPowerOfTwo(num));

        System.out.println(isPowerOfTwoFormula(num));
    }
    public static boolean isPowerOfTwo(int num){
        while(num > 0){
            int bit = num&1;
            num = num>>1;
            if(bit == 1 && num > 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPowerOfTwoFormula(int num){
        if(num == 0){
            return false;
        }
        boolean ans =  (num & (num-1)) == 0;
        return ans;
    }
}
