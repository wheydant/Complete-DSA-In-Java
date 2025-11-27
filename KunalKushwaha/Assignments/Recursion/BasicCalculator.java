package KunalKushwaha.Assignments.Recursion;

public class BasicCalculator{
	int i = 0;
	public int calculate(String s) {
		int result = 0, number = 0, sign = 1;
		while(i < s.length()) {
			char c = s.charAt(i++);
			if(c == '+' || c == '-') {
				result += number * sign;
				number = 0;
				sign = (c == '+')? 1: -1;
			} else if(c == '(') {
				// i++ is done at the begining only so it will calculate inside paranthesis
				number = calculate(s);
			} else if(c == ')') {
				return result += number * sign;
			} else if(c != ' ') {
				//For normal digits
				number = number * 10 + (c - '0');
			}
		}
		result += number * sign;
		return result;
	}
}