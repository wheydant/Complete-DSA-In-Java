
import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 4, 56,4};
        int target = 4;
        System.out.println(linearSearch(arr, 0, target));
        System.out.println(indexVal(arr, 0, target));
        allIndexVal(arr, 0, target);
        System.out.println(list);
        
        ArrayList<Integer> ansList = new ArrayList<>();
        System.out.println(findAllIndex(arr, 0, target, ansList));

        System.out.println(findAllIndex1(arr, 0, target));
    }
    static boolean linearSearch(int[] arr, int index, int target){
        if(index == arr.length){
            return false;
        }
        return arr[index] == target || linearSearch(arr, index + 1, target);
    }
    static int indexVal(int[] arr, int index, int target){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return indexVal(arr, index+1, target);
    }
    static ArrayList<Integer> list = new ArrayList<>();
    static void allIndexVal(int[] arr, int index, int target){
        if(index == arr.length){
            return;
        }
        if(arr[index] == target){
            list.add(index);
        }
        allIndexVal(arr, index+1, target);
    }
    static ArrayList<Integer> findAllIndex(int[] arr, int index, int target, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findAllIndex(arr, index + 1, target, list);
    }
    static ArrayList<Integer> findAllIndex1(int[] arr, int index, int target){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelow =  findAllIndex1(arr, index + 1, target);

        list.addAll(ansFromBelow);

        return list;
    }
}
