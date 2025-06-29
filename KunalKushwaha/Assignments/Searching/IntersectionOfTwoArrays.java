package KunalKushwaha.Assignments.Searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoArrays {
    // II 
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count frequencies of nums1
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Match with nums2
        for (int num : nums2) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1); // Decrease count
            }
        }

        // Convert to int[]
        return result.stream().mapToInt(i -> i).toArray();
    }
    // I
    public int[] intersection(int[] nums1, int[] nums2) {
       Set<Integer> set = new HashSet<>();
       HashMap<Integer, Boolean> map = new HashMap<>();

       for(int i = 0; i < nums1.length; i++){
        map.put(nums1[i], true);
       }
       System.out.println(map);

       for(int i = 0; i < nums2.length; i++){
        if(map.containsKey(nums2[i]))
            set.add(nums2[i]);
       }

       return set.stream().mapToInt(Number::intValue).toArray();
    }
}
