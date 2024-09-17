// The problem provides us with a string s and asks us to determine the length of the longest substring 
// which contains at most two distinct characters. For example, in the string "aabacbebebe," the longest 
// substring with at most two distinct characters is "cbebebe," which has a length of 7.

public class example2 {
    static int test(String str){
        int leftPtr = 0;
        int leftPtrTemp = 0;
        int rightPtr = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(leftPtrTemp) == str.charAt(rightPtr) && leftPtrTemp < str.length()){
                leftPtr = i;
                leftPtrTemp = leftPtr;
                rightPtr = leftPtr + 1;
                // System.out.println("Entered at ");
                // System.out.print(i);
            }else{
                max = rightPtr - leftPtr;
                leftPtrTemp++;
                rightPtr++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(test("aabacbebebe"));
    }
}
