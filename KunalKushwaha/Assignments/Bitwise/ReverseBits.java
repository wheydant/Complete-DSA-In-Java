package KunalKushwaha.Assignments.Bitwise;

public class ReverseBits{
    public int reverseBits(int n) {
        int reversedBits = 0;
        for(int i = 31; i >= 0; i--){
            int bit = n & 1;
            reversedBits = (reversedBits<<1) | bit;
            n = n >> 1;
        }

        return reversedBits;
    }
    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596));
    }
}