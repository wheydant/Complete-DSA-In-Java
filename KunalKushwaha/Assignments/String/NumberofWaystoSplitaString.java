package KunalKushwaha.Assignments.String;

public class NumberofWaystoSplitaString{
    public int numWays(String s) {
        long totalOnes = 0;
        long n = s.length();
        if(n < 3) return 0;
        long mod = 1_000_000_007;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1') totalOnes++;
        }

        //Case 1: totalOnes are not multiple of 3
        if(totalOnes % 3 != 0) return 0;

        //Case 2: All 0 are present then its sum on all the 0
        if(totalOnes == 0) return (int)((((n - 1)*(n - 2))/2)%mod);

        //Case 3: Valid combinations - calculate number of zeros between the valid substring split
        long onesForSubstring = totalOnes/3;
        totalOnes = 0;
        long part1 = 0;
        long part2 = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1') totalOnes++;
            //Calculate all the 0's between part1 & part2 and part2 & part3

            //We hit first valid substring's end
            if(totalOnes == onesForSubstring) part1++;
            //We hit second valid substring's end
            if(totalOnes == 2*onesForSubstring) part2++;
        }

        return (int)((part1*part2)%mod);
    }
}