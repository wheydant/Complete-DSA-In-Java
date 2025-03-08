import java.util.ArrayList;

public class Permutation {
    /*
     * Find all the positions where each element can land
     */
    public static void main(String[] args) {
        String str = "abc";

        permutation(str, "");

        ArrayList<String> arrayList = returnPermutation(str, "");
        System.out.println(arrayList);

        ArrayList<String> ansArrayList = new ArrayList<>();

        permutation(str, "", ansArrayList);
        System.out.println(ansArrayList);

        System.out.println(countPermutation("", str));
    }

    static void permutation(String str, String ans){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i <= ans.length(); i++){

            //Crazy deduction of logic
            String potentialString = ans.substring(0, i) + str.charAt(0) + ans.subSequence(i, ans.length());

            permutation(str.substring(1), potentialString);
        }

    }

    static ArrayList<String> returnPermutation(String str, String ans) {
        ArrayList<String> result = new ArrayList<>();
        if (str.isEmpty()) {
            result.add(ans);
            return result;
        }

        for (int i = 0; i <= ans.length(); i++) {
            String potentialString = ans.substring(0, i) + str.charAt(0) + ans.substring(i);
            result.addAll(returnPermutation(str.substring(1), potentialString));
        }

        return result;
    }

    static void permutation(String str, String ans, ArrayList<String> result) {
        if (str.isEmpty()) {
            result.add(ans);
            return;
        }

        for (int i = 0; i <= ans.length(); i++) {
            String potentialString = ans.substring(0, i) + str.charAt(0) + ans.substring(i);
            permutation(str.substring(1), potentialString, result);
        }
    }

    static int countPermutation(String processed, String unProcessed){
        if(unProcessed.isEmpty()){
            return 1;
        }
        int count = 0;
        for(int i = 0; i <= processed.length(); i++){
            String f = processed.substring(0, i);
            String s = processed.substring(i, processed.length());

            count = count + countPermutation(f + unProcessed.charAt(0) + s, unProcessed.substring(1));
        }

        return count;
    }

}
