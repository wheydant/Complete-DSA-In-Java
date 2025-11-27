package KunalKushwaha.Assignments.Recursion;

public class RemoveConsecutiveDuplicates {
    static String helper(String s1, char prevChar, int index){
        if(index == s1.length()) return "";
        if(prevChar == s1.charAt(index)) return helper(s1, s1.charAt(index), index + 1);
        return s1.charAt(index) + helper(s1, s1.charAt(index), index + 1);
    }
    static String removeDuplicates(String s1){
        return helper(s1, '*', 0);
    }
    public static void main(String[] args)
    {
        String s1 = "geeksforgeeks";
        System.out.println(removeDuplicates(s1));

        String s2 = "aabcca";
        System.out.println(removeDuplicates(s2));
    }
}
