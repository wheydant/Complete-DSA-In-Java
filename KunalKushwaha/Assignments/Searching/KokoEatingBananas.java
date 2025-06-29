package KunalKushwaha.Assignments.Searching;

public class KokoEatingBananas{
    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxPile = 0;
        int minPile = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            maxPile = Math.max(maxPile, piles[i]);
            sum += piles[i];
        }

        int eatingSpeed = 0;
        while(minPile <= maxPile){
            int midPile = (maxPile - minPile)/2 + minPile;

            if(isValid(piles, h, midPile, sum)){
                eatingSpeed = midPile;
                maxPile = midPile - 1;
            }else{
                minPile = midPile + 1;
            }
        }

        return eatingSpeed;
    }

    static boolean isValid(int[] piles, int h,int eatingSpeed, int sum){
        long hoursNeeded = 0;
        for (int pile : piles) {
            // This is an integer math trick for ceil(pile / speed) without using floating point division.
            hoursNeeded += (pile + (long)eatingSpeed - 1) / eatingSpeed; // ceil(pile / eatingSpeed)
        }
        return hoursNeeded <= h;
    }
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}