package KunalKushwaha.Assignments.String;

public class SwapAdjacentInLRString{
    public boolean canTransform(String start, String result) {
        int i = 0;
        int j = 0;
        char[] s = start.toCharArray();
        char[] e = result.toCharArray();
        
        while (i < s.length || j < e.length)
        {
            // stop at char that is not 'X'
            while (i < s.length && s[i] == 'X') i++; 
            while (j < e.length && e[j] == 'X') j++;
            
            if (i >= s.length || j >= e.length)  break;
            
            // 1️⃣ Check characters must match - RX & LX are present
            if (s[i] != e[j]) return false;

            // 2️⃣ Check movement rules
            // R can only move to the right - Afters skipping X's starts R can come before RX -> XR but vice versa is not possible
            if (s[i] == 'R' && i > j) return false;
            // L can only move to the left - Afters skipping X's starts L must come after XL -> LX but vice versa is not possible
            if (s[i] == 'L' && i < j) return false;
            
            // check next
            i++;
            j++;
        }
        
        return i == j;
    }

    public static void main(String[] args) {
        System.out.println(new SwapAdjacentInLRString().canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }
}