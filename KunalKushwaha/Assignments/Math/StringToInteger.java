package KunalKushwaha.Assignments.Math;

public class StringToInteger{
    public int myAtoi(String s) {
        double num = 0;
		boolean isDigitFound = false;
        boolean isSignFound = false;
		boolean isNegative = false;
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
				if(isDigitFound || isSignFound) break;
				if(s.charAt(i) == '-') {
                    if(isSignFound) break;
                    isSignFound = true;
					isNegative = true;
				}else if(s.charAt(i) == '+'){
                    if(isSignFound) break;
                    isSignFound = true;
                }
				else if(s.charAt(i) == ' ') continue;
				else break;
			}else{
				isDigitFound = true;
				num = num*10 + Integer.parseInt(s.charAt(i) + "");
			}
        }

		if(isNegative && isDigitFound) num = num*-1;

		if(num > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}else if(num < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}

		return (int)num;
    }
	public static void main(String[] args) {
		System.out.println(new StringToInteger().myAtoi("words and 987"));
	}
}