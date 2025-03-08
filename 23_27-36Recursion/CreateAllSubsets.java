
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateAllSubsets {
    /*
    abc = a,b,c,ab,ac,bc,abc 
    ca can't be a subset as we are taking set and not permutation thus order cannot be changed.
    */
    public static void main(String[] args) {
        String str = "abc";
        String subStr = "";
        printSubset(str, subStr);
        System.out.println(subset(str, subStr));

        System.out.println(ascii('a'));

        printSubsetWithAscii(str, subStr);

        int[] arr = {1, 2, 3};

        System.out.println(subset(arr));

        arr = new int[]{2, 1, 2};

        System.out.println(duplicateEleSubset(arr));
    }

    static void printSubset(String str, String subStr){
        if(str.isEmpty()){
            System.out.println(subStr);
            return;
        }

        char ch = str.charAt(0);

        //exclude
        printSubset(str.substring(1), subStr); 
        //include
        printSubset(str.substring(1), subStr + ch);

        
    }

    static ArrayList<String> subset(String str, String subStr){
        if(str.isEmpty()){
            ArrayList<String> endNode = new ArrayList<>();
            endNode.add(subStr);
            return endNode;
        }

        char ch = str.charAt(0);

        //include
        ArrayList<String> incl = subset(str.substring(1), subStr + ch);
        //exclude
        ArrayList<String> excl =  subset(str.substring(1), subStr); 
        

        incl.addAll(excl);

        return incl;
    }

    static void printSubsetWithAscii(String str, String subStr){
        if(str.isEmpty()){
            System.out.println(subStr);
            return;
        }

        char ch = str.charAt(0);

        //exclude
        printSubsetWithAscii(str.substring(1), subStr);
        //ASCII
        printSubsetWithAscii(str.substring(1), subStr + ascii(ch));
        //include
        printSubsetWithAscii(str.substring(1), subStr + ch);

        
    }

    static int ascii(char ch){
        return ch + 0;
    }
    /*
     * Complexity - Time = O(N * 2^N)
     *              Space = O(N * 2^N)
     */

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        
        outer.add(new ArrayList<>());
        /*
        * Crazy logic every time a new item is added its added with empty arr then next element + num and so on.
        */
        for(int num : arr){
            int n = outer.size();
            for(int i = 0; i < n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

    static List<List<Integer>> duplicateEleSubset(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        
        outer.add(new ArrayList<>());
        /*
        * Crazy logic every time a new item is added its added with empty arr then next element + num and so on.
        */
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            start = 0;
            if(i > 0 && arr[i] == arr[i - 1]){
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for(int j = start; j < n; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }

        return outer;
    } 
}
