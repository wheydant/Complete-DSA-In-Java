package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrayCode {
	void helper(ArrayList<String> grayCode, Map<String, Boolean> isVisited, int totalCodes){
		if(isVisited.size() == totalCodes){
			return;
		}
		String currCode = grayCode.get(grayCode.size() - 1);
		StringBuilder newCode = new StringBuilder(currCode);
		for(int i = currCode.length() - 1; i >= 0; i--){
			char oldBit = newCode.charAt(i);
			char newBit = currCode.charAt(i) == '0' ? '1': '0';
			newCode.setCharAt(i, newBit);
			if(isVisited.containsKey(newCode.toString())){
				newCode.setCharAt(i, oldBit);
				continue;
			}
			grayCode.add(newCode.toString());
			isVisited.put(newCode.toString(), true);
			break;
		}

		helper(grayCode, isVisited, totalCodes);
	}
    public ArrayList<String> graycode(int n) {
        // code here
        Map<String, Boolean> isVisited = new HashMap<>();
        StringBuilder first = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            first.append("0");
        }
        String baseZero = first.toString();
        
        ArrayList<String> grayCode = new ArrayList<>();
        grayCode.add(baseZero);
        isVisited.put(baseZero, true);
        
        int totalCodes = (int)Math.pow(2, n);
        
        helper(grayCode, isVisited, totalCodes);
        return grayCode;
    }
	public static void main(String[] args) {
		System.out.println(new GrayCode().graycode(3));
	}
}
