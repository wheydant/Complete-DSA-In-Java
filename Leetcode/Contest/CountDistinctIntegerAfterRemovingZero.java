package Leetcode.Contest;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctIntegerAfterRemovingZero {
    long getRemovedZero(long i){
		String noZero = String.valueOf(i).replace("0", "");
		return noZero.isEmpty()? 0:Long.parseLong(noZero);
    }
    public long countDistinct(long n) {
        Map<Long, Boolean> map = new HashMap<>();
        long count = 0;
        
        for(long i = 1; i <= n; i++){
            long num = getRemovedZero(i);
			// System.out.println(num);
            if(map.containsKey(num)) continue;
            count++;
            map.put(i, true);
        }

        return count;
    }
	public static void main(String[] args) {
		System.out.println(new CountDistinctIntegerAfterRemovingZero().countDistinct(21));
	}
}
