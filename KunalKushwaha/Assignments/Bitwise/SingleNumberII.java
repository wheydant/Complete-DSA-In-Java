package KunalKushwaha.Assignments.Bitwise;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        //Counting set bits.
        int mask = 1;
        int singleNum = 0;
        for(int i = 0; i < 32; i++){
            int countBit = 0;
            for(int num : nums){
                int bit = num & mask;
                // System.out.println("Bit at "+ mask +" "+bit);
                if(bit != 0) {
                    countBit++;
                }
            }
            // System.out.println(countBit);
            if(countBit % 3 != 0){
				singleNum |= mask;
			}
            mask = mask << 1;
        }
        return singleNum;
    }
	public static void main(String[] args) {
		System.out.println(new SingleNumberII().singleNumber(new int[]{0,1,0,1,0,1,99}));
	}
}
