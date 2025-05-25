
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        boolean isValid = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                char top;
                if(stack.empty() == false){
                    top = stack.pop();
                }
                else
                    return false;
                switch(top){
                    case '(' -> {
                        if(s.charAt(i) != ')')return false;
                    }
                    case '[' -> {
                        if(s.charAt(i) != ']')return false;
                    }
                    case '{' -> {
                        if(s.charAt(i) != '}')return false;
                    }
                }
            }
        }
        return (stack.isEmpty())?isValid:false; 
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
