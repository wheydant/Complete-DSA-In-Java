package KunalKushwaha.Assignments.Searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class FindRightInterval {
    public static int[] findRightInterval(int[][] intervals) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = intervals.length;
        int n = intervals[0].length;
        int[] sp = new int[m];                  //array of starting points
        
        for(int i = 0; i < m; i++) {
            sp[i] = intervals[i][0];            
            map.put(sp[i], i);                  //(key=start_point, val=index)
        }
        
        Arrays.sort(sp);                        //sort array of starting points
        int[] result = new int[m];
        
        for(int i = 0; i < m; i++) {
            int l = 0, r = m - 1;
            boolean found = false;              //to see if result was found
            int min = -1;
            int ep = intervals[i][n - 1];       //ep = endpoint
            while(l <= r) {                     //binarySearch on arr of start points
                int mid = (l + ((r - l) / 2));
                //This works in comparison with itself also as ends are compared with starts
                if(sp[mid] >= ep) {
                    min = sp[mid];              
                    found = true;               
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            //if found fetch the index there are 
            result[i] = found ? map.get(min) : -1;
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] intervals = {{3,4},{2,3},{1,2}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }
}
