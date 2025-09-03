package KunalKushwaha.Assignments.Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] uniqueArr1 = new int[n - m];
        Arrays.fill(uniqueArr1, 1001);
        int indexUnArr1 = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < m; i++){
            map.put(arr2[i], 0);
        }

        for(int i = 0; i < n; i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }else{
                uniqueArr1[indexUnArr1++] = arr1[i];
            }
        }

        int index = 0;

        for(int i = 0; i < m; i++){
            while(map.get(arr2[i]) > 0){
                arr1[index++] = arr2[i];
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        }

        Arrays.sort(uniqueArr1);
        while(index < n){
            for(int i = 0 ; i < uniqueArr1.length; i++){
                if(uniqueArr1[i] == 1001) return arr1;
                arr1[index++] = uniqueArr1[i];
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        int[] arr2 = {2,1,4,3,9,6};
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};

        RelativeSortArray q = new RelativeSortArray();
        System.out.println(Arrays.toString(q.relativeSortArray(arr1 , arr2)));

        arr1 = new int[]{28,6,22,8,44,17};
        arr2 = new int[]{22,28,8,6};

        System.out.println(Arrays.toString(q.relativeSortArray(arr1 , arr2)));
    }
}
