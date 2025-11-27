package KunalKushwaha.Assignments.Recursion;

public class FirstUpperCaseLetterInAString {
    // Input : geeksforgeeKs
    // Output : K

    // Input  : geekS
    // Output : S
    public static char firstUpperCase(String word) {
        if(word.isEmpty()) return '*';
        if(Character.isUpperCase(word.charAt(0))){
            return word.charAt(0);
        }

        return firstUpperCase(word.substring(1, word.length()));
    }
    public static void main(String[] args) {
        System.out.println(firstUpperCase("geeksforgeeKs"));
        
    }
}
