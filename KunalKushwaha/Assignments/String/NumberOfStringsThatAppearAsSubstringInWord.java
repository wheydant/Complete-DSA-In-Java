package KunalKushwaha.Assignments.String;

public class NumberOfStringsThatAppearAsSubstringInWord {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(int i = 0; i < patterns.length; i++){
            if(word.contains(patterns[i])) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfStringsThatAppearAsSubstringInWord().numOfStrings(new String[]{"a", "abc", "bc", "d"}, "abc")); // 3 a,abc,bc

        System.out.println(new NumberOfStringsThatAppearAsSubstringInWord().numOfStrings(new String[]{"a", "b", "c", "bc"}, "aaaaabbbbb")); // 2 a,b
    }
}
