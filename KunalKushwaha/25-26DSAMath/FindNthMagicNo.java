public class FindNthMagicNo {
    public static void main(String[] args) {
        int n = 6; // Example input
        System.out.println("The " + n + "th magic number is: " + findNthMagicNo(n));
    }
    public static int findNthMagicNo(int n){
        int ans = 0;
        int base = 5;
        int mask = 1;
        int power = 1;
        while(n > 0){
            int last = n & 1;
            n = n >> 1;
            ans += last*base;
            base = base * 5;
        }
        // while(n > 0){
        //     int bit = n&mask;
        //     if(bit>0){
        //         bit = 1;
        //     }
        //     ans += bit*(Math.pow(base, power));
        //     n = n&(~mask);
        //     mask = mask<<1;
        //     power++;
        // }
        return ans;
    }
}
