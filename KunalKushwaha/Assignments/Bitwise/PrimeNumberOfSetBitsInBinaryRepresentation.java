package KunalKushwaha.Assignments.Bitwise;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    int countBits(int n){
        int bits = 0;
        while(n != 0){
            int bit = n&1;
            bits += (bit == 1)? 1:0;
            n = n>>1;
        }
        return bits;
    }
    boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public int mySolCountPrimeSetBits(int left, int right) {
        int primeBits = 0;
        for(int i = left; i <= right; i++){
            int bits = countBits(i);
            // System.out.println(bits);
            if(isPrime(bits)){
                // System.out.println(left + " has prime bits");
                primeBits++;
            }
        }

        return primeBits;
    }
	public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);
            if (isPrimeOptimum(bits)) count++;
        }
        return count;
    }

    private boolean isPrimeOptimum(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
