package KunalKushwaha.Assignments.Recursion;

public class DecodeString {
	// originalString.repeat(n);
	String decodedString(String s,String currString, int i, int multiple){
		if(i == s.length()){
			if(multiple == 0)
				return currString.repeat(1);
			return currString.repeat(multiple);
		}
		char currChar = s.charAt(i);
		if(Character.isDigit(currChar)){
			if(i > 0){
				if(Character.isDigit(s.charAt(i - 1)))
					return currString + decodedString(s, "", i + 1, multiple*10 + Integer.parseInt(currChar + ""));
			}
			if(multiple == 0)
				return (currString + decodedString(s, "", i + 1, Integer.parseInt(currChar + ""))).repeat(1);
			return (currString + decodedString(s, "", i + 1, Integer.parseInt(currChar + ""))).repeat(multiple);
		}else if(currChar == '['){
			return currString + decodedString(s, "", i + 1, multiple);
		}else if(currChar == ']'){
			return currString.repeat(multiple) + decodedString(s, "", i + 1, 0);
		}
		return decodedString(s, currString + currChar, i + 1, multiple);
	}
	StringBuilder decodeHelper(String s, int[] index){
		StringBuilder result = new StringBuilder();
		int n = s.length();
		int num = 0;

		while(index[0] < n){
			char c = s.charAt(index[0]);

			if(Character.isDigit(c)){
				num = num * 10 + (c - '0');
			} else if(c == '['){
				index[0]++;
				StringBuilder sub = decodeHelper(s, index);

				result.append(sub.toString().repeat(num));
				num = 0;
			} else if (c == ']'){
				break;
			} else {
				result.append(c);
			}
			index[0]++;
		}

		return result;
	}
	public String decodeString(String s) {
		//It act like a reference variable
		int[] index = {0};
		return decodeHelper(s, index).toString();
	}
	public static void main(String[] args) {
		System.out.println(new DecodeString().decodeString("3[a2[c]]"));
		System.out.println(new DecodeString().decodeString("z11[a]3[cd]ef"));
		System.out.println(new DecodeString().decodeString("z11[a]3[cd]"));
	}
}
