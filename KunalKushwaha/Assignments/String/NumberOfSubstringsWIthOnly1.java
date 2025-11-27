package KunalKushwaha.Assignments.String;

public class NumberOfSubstringsWIthOnly1{
    public int numSub(String s) {
        long count = 0, res = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                count++;
            }
            else {
                res += (count*(count+1))/2;
                count = 0;
            }
        }
        res = res % 1_000_000_007;
        return (count == 0) ? (int)res : (int)(res += (count*(count+1))/2);
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSubstringsWIthOnly1().numSub("0110111"));
    }
}