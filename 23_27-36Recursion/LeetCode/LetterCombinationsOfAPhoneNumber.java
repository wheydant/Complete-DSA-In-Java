package LeetCode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        List<String> ans = letterCombinations("");
        System.out.println(ans);
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.compareTo("") == 0){
            return new ArrayList<String>();
        }
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        return letterComList(digits, mapping, "");
    }

    static List<String> letterComList(String digits, String[] mapping, String processed){
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            ans.add(processed);
            return ans;
        }
        //Tricky logic.
        int number = digits.charAt(0) - '0';
        String letters = mapping[number];

        // System.out.println(letters);

        for(int i = 0; i < letters.length(); i++){
            String potentialString = processed + letters.charAt(i);
            //Compiler tackles it debuggers fucks with this code
            ans.addAll(letterComList(digits.substring(1), mapping,potentialString));
        }
        return ans;
    }
}
