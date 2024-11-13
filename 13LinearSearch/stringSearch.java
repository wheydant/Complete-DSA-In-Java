/**
 * stringSearch
 */
public class stringSearch {

    public static void main(String[] args) {
        String inputString = "Hello World";
        char target = 'e';
        
        System.out.println(linearSearch(inputString, target));
    }
    static boolean linearSearch(String inpuString, char target){
        if(inpuString.length() == 0)
            return false;

        //Converts String to an array to charachters
        for(char c : inpuString.toCharArray()){
            if(c == target)
                return true;
        }

        return false;
    }
}