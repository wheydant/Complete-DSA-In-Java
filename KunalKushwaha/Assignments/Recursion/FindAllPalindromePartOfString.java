
import java.util.ArrayList;
import java.util.List;

public class FindAllPalindromePartOfString {
    static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    static void helper(int idx, List<List<String>> ans, List<String> currAns, String s){
        if(idx == s.length()){
            ans.add(new ArrayList<>(currAns));
            return;
        }

        StringBuilder tempString = new StringBuilder();

        for(int i = idx; i < s.length(); i++){
            tempString.append(s.charAt(i));
            if(isPalindrome(tempString.toString())){
                currAns.add(tempString.toString());
                helper(idx + 1, ans, currAns, s);
                //backtrack
                currAns.remove(currAns.size() - 1);
            }
        }
    }
    static List<List<String>> PalindromePart(String s){
        List<List<String>> ans = new ArrayList<>();
        List<String> currAns = new ArrayList<>();
        helper(0, ans, currAns, s);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(PalindromePart("geek"));
    }
}
