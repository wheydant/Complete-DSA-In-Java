package KunalKushwaha.Assignments.String;

// S1 = "0"
// S2 = "011"
// S3 = "0111001"
// S4 = "011100110110001"

public class FindKthBitInNthBinaryString {
    String binaryStr(int n){
        StringBuilder S = new StringBuilder();
        S.append("0");
        for(int i = 1; i < n; i++){
            StringBuilder tempS = new StringBuilder(S);
            S.reverse();
            for(int j = 0; j < S.length(); j++){
                if(S.charAt(j) == '1'){
                    S.setCharAt(j, '0');
                }else
                    S.setCharAt(j, '1');
            }
            tempS.append("1");
            // System.out.println(S);
            tempS.append(S);
            S = tempS;
            // System.out.println(S);
        }
        return S.toString();
    }
    public char findKthBit(int n, int k) {
        String S = binaryStr(n);

        System.out.println(S);
        return S.charAt(k - 1);
    }
    public char findKthBitRec(int n, int k) {
        // Base case: When n = 1, the binary string is "0"
        if (n == 1) return '0';
        
        // Find the length of the current string Sn, which is 2^n - 1
        // Just a fancy way to write 2^n -1
        int length = (1 << n) - 1;
        
        // Find the middle position
        int mid = length / 2 + 1;
        
        // If k is the middle position, return '1'
        if (k == mid) return '1';
        
        // If k is in the first half, find the bit in Sn-1
        if (k < mid) return findKthBitRec(n - 1, k);
        
        // If k is in the second half, find the bit in Sn-1 and invert it
        return findKthBitRec(n - 1, length - k + 1) == '0' ? '1' : '0';
    }
    public static void main(String[] args) {
        System.out.println(new FindKthBitInNthBinaryString().findKthBit(4, 0));
    }
}
