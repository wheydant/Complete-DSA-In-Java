
import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        int rightParenthesis = 0;
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    rightParenthesis++;
                }else{
                    stack.pop();
                }
            }
        }

        return (stack.isEmpty() && rightParenthesis != 0)? rightParenthesis : stack.size() + rightParenthesis;
    }
    public static int minAddToMakeValidKK(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
    public static void main(String[] args) {
        String s = ")())(";
        System.out.println(minAddToMakeValid(s));
    }
}
