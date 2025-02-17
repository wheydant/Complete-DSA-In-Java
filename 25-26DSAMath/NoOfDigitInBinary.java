public class NoOfDigitInBinary {
   public static void main(String[] args) {
    int num = 6;
    int base = 2;
    System.out.println("Number of bits in "+num+" = "+findBits(num));
    System.out.println("Number of bits in "+num+" with base "+base+" = "+findBitsFormula(num, base));
   } 
   public static int findBits(int num){
    int counter = 0;
    while(num > 0){
        counter++;
        num = num >> 1;
    }
    return counter;
   }
   public static int findBitsFormula(int num, int base){
    int ans = (int)(Math.log(num) / Math.log(base)) + 1;
    return ans;
   }
}
