package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
	void helper(String s, Map<Character, List<String>> map, StringBuilder curr, List<String> ans){
		if(s.length() == 0){
			// curr.delete(0, 1);
			
			ans.add(curr.toString());
			return;
		}

		List<String> currList = map.get(s.charAt(0));
		if(currList == null) return;

		for(int i = 0; i < currList.size(); i++){
			String word = currList.get(i);
			if(s.startsWith(word)){
				int currLen = curr.length();
				if(currLen != 0) curr.append(" ");
				curr.append(word);
				helper(s.substring(word.length()), map, curr, ans);
				curr.delete(currLen, curr.length());
			}
		}
	}
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
		Map<Character, List<String>> map = new HashMap<>();
		for(int i = 0; i < wordDict.size(); i++){
			List<String> temp = map.getOrDefault(wordDict.get(i).charAt(0), new ArrayList<>());
			temp.add(wordDict.get(i));
			map.put(wordDict.get(i).charAt(0), temp);
		}
		helper(s, map, new StringBuilder(),ans);
		return ans;
    }
	public static void main(String[] args) {
		System.out.println(new WordBreakII().wordBreak("pineapplepenapple", List.of("apple","pen","applepen","pine","pineapple")));
	}
}
