package KunalKushwaha.Assignments.Bitwise;

import java.util.HashMap;
import java.util.Map;

public class LongestNiceSubString {
    public String longestNiceSubstring(String s) {
        int n = s.length();
		int maxLen = Integer.MIN_VALUE;
		String ans = new String();
        for(int i = 0; i < n; i++){
            Map<Character, Boolean> map = new HashMap<>();
			for(int j = i; j < n; j++){
				Character ch = s.charAt(j);
				if(Character.isLowerCase(ch) && map.containsKey(Character.toUpperCase(ch))){
					map.put(Character.toUpperCase(ch), true);
				}
				if(Character.isUpperCase(ch) && map.containsKey(Character.toLowerCase(ch))){
					map.put(Character.toLowerCase(ch), true);
				}
				if(!map.containsKey(Character.toLowerCase(ch)) && !map.containsKey(Character.toUpperCase(ch))){
					map.put(ch, false);
				}

				boolean flag = true;
				for(var key: map.keySet()){
					if(!map.get(key)){
						flag = false;
						break;
					}
				}
				if(flag){
					if(j - i > maxLen){
						maxLen = j - i;
						ans = s.substring(i, j + 1);
					}
				}
			}
        }

		return ans;
    }
	public static void main(String[] args) {
		System.out.println(new LongestNiceSubString().longestNiceSubstring("YayAzaAabBby"));
	}
}
