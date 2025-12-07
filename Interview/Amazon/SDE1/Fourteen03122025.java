package Interview.Amazon.SDE1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fourteen03122025 {
	// Q1. 
	int maximizePowerOutput(int[][] power) {
		// Create a copy to avoid modifying original
		int[][] powerCopy = new int[power.length][];
		for (int i = 0; i < power.length; i++) {
			powerCopy[i] = power[i].clone();
			Arrays.sort(powerCopy[i]);
		}

		boolean[] hasDonated = new boolean[power.length];
		return maximizePowerOutputHelper(powerCopy, hasDonated, 0);
	}

	int maximizePowerOutputHelper(int[][] power, boolean[] hasDonated, int donorIdx) {
		// Calculate current power
		int currentPower = 0;
		for (int[] p : power) {
			currentPower += p[0];
		}

		// Try to find next donor
		int maxPower = currentPower;
		for (int i = donorIdx; i < power.length; i++) {
			if (hasDonated[i])
				continue;

			// Check if machine i can donate (has more than minimum)
			if (power[i].length > 1 && power[i][power[i].length - 1] > power[i][0]) {
				// Try donating to each other machine
				for (int j = 0; j < power.length; j++) {
					if (i == j)
						continue;

					// Check if receiving helps machine j
					if (power[j].length == 1 || power[j][0] < power[j][1]) {
						// Donate: remove from donor, add to receiver
						int donorLast = power[i][power[i].length - 1];
						power[i][power[i].length - 1]--;
						power[j][0]++;
						hasDonated[i] = true;

						int newPower = maximizePowerOutputHelper(power, hasDonated, i + 1);
						maxPower = Math.max(maxPower, newPower);

						// Backtrack
						power[i][power[i].length - 1]++;
						power[j][0]--;
						hasDonated[i] = false;
					}
				}
			}
		}

		return maxPower;
	}

	//Q2
	int maxGCDSubarray(int[] arr, int k) {

        int n = arr.length;
        Set<Integer> primes = new HashSet<>();

        // Step 1: collect candidate primes
        for (int x : arr) {
			//addAll adds all the value from the collection
            primes.addAll(primeFactors(x));
        }

        int best = 1; // at least 1

        // Step 2: Try each prime as target GCD factor
        for (int p : primes) {

            int L = 0;
            int needChange = 0;

            for (int R = 0; R < n; R++) {

                if (arr[R] % p != 0)
                    needChange++;

                // shrink window if too many changes needed
                while (needChange > k) {
                    if (arr[L] % p != 0)
                        needChange--;
                    L++;
                }

                best = Math.max(best, R - L + 1);
            }
        }

        return best;
    }
	// Return distinct prime factors of x
    static List<Integer> primeFactors(int x) {
        List<Integer> factors = new ArrayList<>();
        int num = x;

        for (int p = 2; p * p <= num; p++) {
            if (num % p == 0) {
                factors.add(p);
                while (num % p == 0) num /= p;
            }
        }


        if (num > 1) factors.add(num); // remaining prime
		System.out.println("For " + x +" " + factors);
        return factors;
    }

	public static void main(String[] args) {
		// System.out.println(new Fourteen03122025().maximizePowerOutput(new int[][] { { 1, 5 }, { 2, 3 }, { 1, 0 } }));
		// System.out.println(new Fourteen03122025().maximizePowerOutput(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } }));

		System.out.println(new Fourteen03122025().maxGCDSubarray(new int[]{2, 7, 3, 9, 4, 14}, 2));
	}
}

class PowerDistributionOptimized {

	static class MachineState {
		List<Integer> units; // Sorted list of power units
		boolean hasDonated;

		MachineState(int[] powers) {
			units = new ArrayList<>();
			for (int p : powers) {
				units.add(p);
			}
			Collections.sort(units);
			hasDonated = false;
		}

		int getCurrentPower() {
			return units.isEmpty() ? 0 : units.get(0);
		}

		boolean canDonate() {
			if (hasDonated || units.isEmpty())
				return false;
			return units.get(units.size() - 1) > units.get(0);
		}

		// Returns benefit of receiving 1 power unit
		int benefitFromReceiving() {
			if (units.isEmpty())
				return 1;
			int currentMin = units.get(0);
			// Check if receiving 1 unit increases the minimum
			if (units.size() == 1 || currentMin < units.get(1)) {
				return 1;
			}
			return 0;
		}

		void donate() {
			if (canDonate()) {
				// Remove the largest power unit
				units.remove(units.size() - 1);
				hasDonated = true;
			}
		}

		void receive() {
			// Add 1 to the minimum power unit
			if (!units.isEmpty()) {
				int min = units.remove(0);
				units.add(min + 1);
				Collections.sort(units);
			} else {
				units.add(1);
			}
		}
	}

	public int maximizePowerOutput(int[][] power) {
		int n = power.length;
		MachineState[] machines = new MachineState[n];

		for (int i = 0; i < n; i++) {
			machines[i] = new MachineState(power[i]);
		}

		// Greedy approach: repeatedly find best donation
		boolean improved = true;
		while (improved) {
			improved = false;

			int bestDonor = -1;
			int bestReceiver = -1;
			int bestGain = 0;

			// Find best donor-receiver pair
			for (int i = 0; i < n; i++) {
				if (!machines[i].canDonate())
					continue;

				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;

					int gain = machines[j].benefitFromReceiving();
					if (gain > bestGain) {
						bestGain = gain;
						bestDonor = i;
						bestReceiver = j;
					}
				}
			}

			// Make the best donation if found
			if (bestDonor != -1 && bestGain > 0) {
				machines[bestDonor].donate();
				machines[bestReceiver].receive();
				improved = true;
			}
		}

		// Calculate total power
		int totalPower = 0;
		for (MachineState m : machines) {
			totalPower += m.getCurrentPower();
		}

		return totalPower;
	}

	public static void main(String[] args) {
		PowerDistributionOptimized solver = new PowerDistributionOptimized();

		System.out.println("Test 1: " + solver.maximizePowerOutput(new int[][] {
				{ 1, 5 }, { 2, 3 }, { 1, 0 }
		})); // Expected: 5

		System.out.println("Test 2: " + solver.maximizePowerOutput(new int[][] {
				{ 1, 1 }, { 2, 2 }, { 3, 3 }
		})); // Expected: 6 (no change)

		System.out.println("Test 3: " + solver.maximizePowerOutput(new int[][] {
				{ 1, 1, 5 }, { 2, 2 }, { 0, 3 }
		})); // Expected: higher value

		System.out.println("Test 4: " + solver.maximizePowerOutput(new int[][] {
				{ 3, 6 }, { 1, 4 }, { 2, 5 }
		})); // Multiple donations possible
	}
}