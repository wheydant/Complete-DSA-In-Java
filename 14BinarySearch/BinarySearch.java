public class BinarySearch {
    public static void main(String[] args) {
        int[] arrAss = {1,2,3,4,5};
        int[] arrDes = {5,4,3,2,1};
        System.out.println(binarySearch(arrAss, 0));
        System.out.println(agnosticBinarySearch(arrDes, 2));
        System.out.println(agnosticBinarySearch(arrAss, 2));
    }
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            // int mid = (start + end)/2; Faulty method can excede the range of int
            int mid = start + (end-start)/2;

            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    //Order Agnostic where order is unknown
    static int agnosticBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        char order = (arr[start] < arr[end])? 'A':'D';
        while(start <= end){
            int mid = end - (end-start)/2;

            if(target < arr[mid]){
                end = (order == 'A')? (mid - 1) : end;
                start = (order == 'D')? (mid + 1) : start;
            }
            else if(target > arr[mid]){
                start = (order == 'A')? mid + 1 : start;
                end = (order == 'D')? (mid - 1) : end;
            }else{
                return mid;
            }
            
        }
        return -1;
    }
}

