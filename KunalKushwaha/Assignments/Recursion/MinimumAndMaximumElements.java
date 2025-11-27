package KunalKushwaha.Assignments.Recursion;

public class MinimumAndMaximumElements {
    static int minRec(int[] arr, int min, int i, int n){
        if(i == n) return min;
        min = Math.min(arr[i], min);
        return minRec(arr, min, i + 1, n);
    }
    static int maxRec(int[] arr, int max, int i, int n){
        if(i == n) return max;
        max = Math.max(arr[i], max);
        return maxRec(arr, max, i + 1, n);
    }
    public static void MinMax(int[] arr) {
        int min = minRec(arr, Integer.MAX_VALUE, 0, arr.length);
        int max = maxRec(arr, Integer.MIN_VALUE, 0 , arr.length);

        System.out.println("Min "+ min+" Max "+ max);
    }
    public static void main(String[] args) {
        MinMax(new int[]{1,4,3,-5,-4,8,6});
    }
}
