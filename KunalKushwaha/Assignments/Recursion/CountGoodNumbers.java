public class CountGoodNumbers{
int mod = 1_000_000_007;

    //Stack overflow
    long helper(long n) {
        if (n == 0) return 1;

        //Go to the bottommost recursion
        long val = helper(n - 1) % mod;

        if (n % 2 != 0)
            return (5 * val) % mod;  // Odd index (5 options) → multiply by 5
        else
            return (4 * val) % mod;  // Even index (4 options) → multiply by 4
    }

    private long powMod(long base, long exp) {
        long result = 1;
        base = base % mod;

        while(exp > 0) {
            if((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }

    public int countGoodNumbers(long n) {
        long evenPositions = (n+1)/2;
        long oddPositions = n/2;

        long evenPart = powMod(5, evenPositions);
        long oddPart = powMod(4, oddPositions);

        return (int) ((evenPart * oddPart) % mod);
    }
}