package KunalKushwaha.Assignments.Recursion;

public class SortedArray {
    static boolean helper(int[] arr, int n){
        if(n == 0) return true;
        return arr[n] >= arr[n - 1] && helper(arr, n - 1);
    }
    static boolean isSorted(int[] arr){
        return helper(arr, arr.length - 1);
    }
    public static void main(String[] args) {

        int arr[] = { 10, 20, 30, 40, 50 };
        int n = arr.length;

        if (isSorted(arr))
            System.out.print("true");
        else
            System.out.print("false");
    }
}
