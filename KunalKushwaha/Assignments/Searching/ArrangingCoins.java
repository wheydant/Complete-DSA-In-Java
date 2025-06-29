package KunalKushwaha.Assignments.Searching;

public class ArrangingCoins {
    public int arrangeCoinsBrute(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    public int arrangeCoins(int n) {
        long start = 1;
        long end = n;
        long ans = 0;
        long mid = 0;
        
        while(start <= end) {
            mid = start + (end-start)/2;
            
            long coinCount = (mid*(mid+1))/2;
                
                if(coinCount <= n){
                    ans = mid;
                    start = mid+1;
                } else {
                    end = mid-1;
                }
        }
        return (int)ans;
    }
}
