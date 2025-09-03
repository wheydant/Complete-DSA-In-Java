package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class SortArrayByIncreasingFrequency{
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Integer[] boxedArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArr, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if(freqA == freqB) return -(a - b);
            return freqA - freqB;
        });

        return Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
    }
    public int[] frequencySortOptimum(int[] nums) {
        // Step 1: Count frequency of each number
        int[] freq = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            freq[i] = count;
        }

        // Step 2: Sort nums according to rules:
        //  - smaller frequency first
        //  - if frequency equal → larger number first
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (freq[i] > freq[j] || (freq[i] == freq[j] && nums[i] < nums[j])) {
                    // swap nums
                    int tempNum = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tempNum;

                    // swap freq
                    int tempFreq = freq[i];
                    freq[i] = freq[j];
                    freq[j] = tempFreq;
                }
            }
        }

        return nums;
    }
}