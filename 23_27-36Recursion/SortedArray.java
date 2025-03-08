public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 4, 5};
        System.out.println(isSorted(arr, 0, 1));
        System.out.println(isSorted1(arr, 0));
    }
    static boolean isSorted(int[] arr, int i, int j){
        if(j >= arr.length){
            return true;
        }
        if(arr[i] > arr[j]){
            return false;
        }
        return isSorted(arr, ++i, ++j);
    }
    static boolean isSorted1(int[] arr, int index){
        if(index == arr.length - 1){
            return true;
        }
        return arr[index] < arr[index + 1] && isSorted1(arr, index + 1);
    }
}
