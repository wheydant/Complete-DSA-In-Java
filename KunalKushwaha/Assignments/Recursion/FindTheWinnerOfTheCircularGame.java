package KunalKushwaha.Assignments.Recursion;

import java.util.HashMap;
import java.util.Map;

public class FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        Map<Integer, Boolean> roundTable = new HashMap<>();
		for(int i = 0; i < n; i++){
			roundTable.put(i, true);
		}
		int index = 0;
		int tempCount = n;
		while(tempCount > 1){
			int count = 0;
			while(true){
				if(roundTable.get(index)){
					count++;
				}
				if(count >= k){
					roundTable.put(index, false);
					index = (index + 1)%n;
					break;
				}
				index = (index + 1)%n;
			}
			System.out.println(roundTable);
			tempCount--;
		}

		for(var key: roundTable.keySet()){
			if(roundTable.get(key)) return key + 1;
		}

		return -1;
    }

	int helper(int n, int k){
        if(n == 1) return 0;
        return (helper(n - 1, k) + k)%n;
    }
    public int findTheWinnerOptimum(int n, int k) {
        return helper(n, k) + 1;
    }
	public static void main(String[] args) {
		System.out.println(new FindTheWinnerOfTheCircularGame().findTheWinner(5, 2));
		// Here are the steps of the game:
		// 1) Start at friend 1.
		// 2) Count 2 friends clockwise, which are friends 1 and 2.
		// 3) Friend 2 leaves the circle. Next start is friend 3.
		// 4) Count 2 friends clockwise, which are friends 3 and 4.
		// 5) Friend 4 leaves the circle. Next start is friend 5.
		// 6) Count 2 friends clockwise, which are friends 5 and 1.
		// 7) Friend 1 leaves the circle. Next start is friend 3.
		// 8) Count 2 friends clockwise, which are friends 3 and 5.
		// 9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.
	}	
}
