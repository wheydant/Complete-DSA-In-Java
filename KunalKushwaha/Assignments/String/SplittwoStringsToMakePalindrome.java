package KunalKushwaha.Assignments.String;

public class SplittwoStringsToMakePalindrome {

    class MySolution {
        boolean isPalindrome(String a, String b, int start, int end, int n){
            for(int i = start; i <= end; i++){
                if(a.charAt(i) != b.charAt(n - 1 - i)) return false;
            }

            return true;
        }
        boolean helper(String a, String b){
            int n = a.length();
            if(isPalindrome(a, a, 0, n/2, n) || isPalindrome(b, b, 0, n/2, n)) return true;

            for(int i = 0; i < n/2; i++){
                if(isPalindrome(a, b, 0, i, n)) return true;
            }

            return false;
        }
        public boolean checkPalindromeFormation(String a, String b) {
            return helper(a, b) || helper(b,a);
        }
    }

    // Check if substring from start to end is palindrome in string s
    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    
    // Check if we can form palindrome by taking prefix from 'first' and suffix from 'second'
    boolean helper(String first, String second) {
        int n = first.length();
        int left = 0, right = n - 1;
        
        // Move inward while characters match (prefix from first, suffix from second)
        while (left < right && first.charAt(left) == second.charAt(right)) {
            left++;
            right--;
        }
        
        // If we've matched the entire string, it forms a palindrome
        if (left >= right) return true;
        
        // At this point, first[left] != second[right]
        // We have two choices for the middle part:
        
        // Choice 1: Use remaining part from 'first' string (first[left...right])
        if (isPalindrome(first, left, right)) return true;
        
        // Choice 2: Use remaining part from 'second' string (second[left...right])
        if (isPalindrome(second, left, right)) return true;
        
        return false;
    }
    
    public boolean checkPalindromeFormation(String a, String b) {
        return helper(a, b) || helper(b, a);
    }
    
    public static void main(String[] args) {
        SplittwoStringsToMakePalindrome solution = new SplittwoStringsToMakePalindrome();
        
        // Test cases
        String[][] testCases = {
            {"x", "y"},           // false
            {"xbdef", "xecab"},   // false  
            {"ulacfd", "jizalu"}, // true -> "ula" + "alu" = "ulaalu" (palindrome)
            {"abdef", "fecab"},   // true -> "ab" + "ba" = "abba" (palindrome) 
            {"abcd", "dcba"},     // true -> "abcd" + "" = "abcd" (take dcba reversed)
            {"abc", "def"}        // false
        };
        
        System.out.println("=== Testing Split Two Strings to Make Palindrome ===");
        for (String[] test : testCases) {
            String a = test[0], b = test[1];
            boolean result = solution.checkPalindromeFormation(a, b);
            
            System.out.printf("a='%s', b='%s' -> %b\n", a, b, result);
        }
        
        // Detailed explanation for one example
        System.out.println("\n=== Detailed Example ===");
        String a = "ulacfd", b = "jizalu";
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Checking if we can form palindrome...");
        
        // Manual trace
        System.out.println("Matching from outside:");
        System.out.println("a[0]='u' == b[5]='u' ✓");
        System.out.println("a[1]='l' == b[4]='l' ✓"); 
        System.out.println("a[2]='a' != b[3]='a' Wait... they do match!");
        System.out.println("So we can take prefix 'ula' from a and suffix 'alu' from b");
        System.out.println("Result: 'ula' + 'alu' = 'ulaalu' which IS a palindrome!");
    }
}