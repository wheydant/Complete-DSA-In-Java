package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthesis{
	List<Integer> helper(int s, int e, String expression){
		if(e - s <= 1){
			String number = expression.substring(s, e + 1);
			List<Integer> ans = new ArrayList<>();
			ans.add(Integer.valueOf(number));
			return ans;
		}
		List<Integer> ans = new ArrayList<>();
		for(int i = s; i < e; i++){
			if(Character.isDigit(expression.charAt(i))){
				continue;
			}else{
				List<Integer> left = helper(s, i - 1, expression);
				List<Integer> right = helper(i + 1, e, expression);
				Character operation = expression.charAt(i);
				for(int j = 0; j < left.size(); j++){
					for(int k = 0; k < right.size(); k++){
						int eval = 0;
						switch(operation){
							case '+':
								eval = left.get(j) + right.get(k);
								break;
							case '-':
								eval = left.get(j) - right.get(k);
								break;
							case '*':
								eval = left.get(j) * right.get(k);
								break;
						}
						ans.add(eval);
					}
				}
			}
		}
		return ans;
	}
	public List<Integer> diffWaysToCompute(String expression) {
		return helper(0, expression.length() - 1, expression);
	}
	public static void main(String[] args) {
		System.out.println(new DifferentWaysToAddParenthesis().diffWaysToCompute("22*3-4*5"));
	}
}