package Interview.Amazon.SDE1;

public class Thirteen03122025 {
	int maxKConsistency(int[] stockPrices, int k){
		return maxKConsistencyHelper(0, stockPrices, k);
	}

	int maxKConsistencyHelper(int i, int[] stockPrices, int k){
		int price = stockPrices[i];
		int continuous = 0;
		int tempK = k;
		int nextIndex = -1;
		while(i < stockPrices.length && tempK >= 0){
			if(price == stockPrices[i]) continuous++;
			else{
				if(nextIndex == -1){
					nextIndex = i;
				}
				tempK--;
			}
			i++;
		}

		if(nextIndex == -1) return continuous;
		return Math.max(continuous, maxKConsistencyHelper(nextIndex, stockPrices, k));
	}
	public static void main(String[] args) {
		System.out.println(new Thirteen03122025().maxKConsistency(new int[]{3, 3, 1, 3, 2, 3, 3}, 2));

		System.out.println(new Thirteen03122025().maxKConsistency(new int[]{10, 10, -1, -1, 10, -1, -2, -2, -2,-1,-1}, 3));

		System.out.println(new Thirteen03122025().maxKConsistency(new int[]{1, 2, 1, 1, 1}, 1));

		System.out.println(new Thirteen03122025().maxKConsistency(new int[]{5, 1, 5, 5, 5}, 1));

		System.out.println(new Thirteen03122025().maxKConsistency(new int[]{1,2,2,1,2,2,2,1}, 2));
	}
}
