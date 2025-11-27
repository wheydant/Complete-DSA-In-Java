package KunalKushwaha.Assignments.String;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        // '+', '-', '*', '/'

        if(s == null || s.length() == 0) return 0;

        Stack<Integer> st = new Stack<>();

        //Curr is important as we dont have digits with just 0-9
        int curr = 0;

        char op = '+';

        char[] equation = s.toCharArray();

        for(int i = 0; i < equation.length; i++){
            char ch = equation[i];
            //Digit
            if(Character.isDigit(ch)){
                //As till its digit create a whole number eg. '1', '2' 1*10 + 2
                curr = curr*10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == equation.length - 1) {
                if (op == '+') st.push(curr);
                else if (op == '-') st.push(-curr);
                else if (op == '*') st.push(st.pop() * curr);
                else if (op == '/') st.push(st.pop() / curr);

                op = ch;
                curr = 0;
            }
            System.out.println(st);
        }

        int sum = 0;
        for (Integer num : st) sum += num;

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate("3+5/2"));
    }
}
