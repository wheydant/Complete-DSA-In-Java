package KunalKushwaha.Assignments.Recursion;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArrangement{
	int helper(int i, int n, Map<Integer, Boolean> map){
		if(i > n){
			// System.out.println(map);
			return 1;
		}
		int count = 0;
		for(int idx = 1; idx <= n; idx++){
			if(!map.get(idx) && (idx%i == 0 || i%idx == 0)){
				map.put(idx, true);
				count += helper(i + 1, n, map);
				map.put(idx, false);
			}
		}
		return count;
	}
    public int countArrangement(int n) {
		Map<Integer, Boolean> map = new HashMap<>();
		for(int i = 1; i <= n; i++){
			map.put(i, false);
		}
        return helper(1, n, map);
    }
	public static void main(String[] args) {
		System.out.println(new BeautifulArrangement().countArrangement(2));
		System.out.println(new BeautifulArrangement().countArrangement(3));
	}
}