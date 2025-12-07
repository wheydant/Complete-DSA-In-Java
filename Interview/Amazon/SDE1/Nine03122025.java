package Interview.Amazon.SDE1;

import java.util.Arrays;

public class Nine03122025 {
	// Q1
	int minimumStartingHealth(int[] power, int armor){
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int p : power){
			if(p > max)max = p;
			sum += p;
		}
		return sum - Math.min(armor, max) + 1;
	}

	// Q2
	int getMaxThroughput(int[] host_throughput){
		Arrays.sort(host_throughput);
		int left = 0;
		int right = host_throughput.length - 1;
		int sysThroughput = 0;

		while(left < right){
			right--;
			if(right > left){
				sysThroughput += host_throughput[right];
			}else break;
			left++;
			right--;
		}

		return sysThroughput;
	}

	public static void main(String[] args) {
		// System.out.println(new Nine03122025().minimumStartingHealth(new int[]{1, 2, 6, 7}, 5));

		System.out.println(new Nine03122025().getMaxThroughput(new int[]{4, 6, 3, 5, 4, 5}));

		System.out.println(new Nine03122025().getMaxThroughput(new int[]{2, 3, 4, 3,4}));

		System.out.println(new Nine03122025().getMaxThroughput(new int[]{2, 3, 4}));
	}
}
