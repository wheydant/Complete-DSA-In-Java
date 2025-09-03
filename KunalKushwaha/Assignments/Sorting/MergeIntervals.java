package KunalKushwaha.Assignments.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int[] prev = intervals[0];
        for(int i = 1; i < n; i++){
            int[] curr = intervals[i];
            if(curr[0] <= prev[1]){
                prev[1] = Math.max(curr[1], prev[1]);
                //Shouldn't add directly as we might find multiple overlapping arrays [1, 3], [2, 5], [4, 6] => [1, 6]
            }else{
                ans.add(prev);
                prev = curr;
            }
        }
        ans.add(prev);
        return ans.toArray(new int[ans.size()][]);
    }
}
