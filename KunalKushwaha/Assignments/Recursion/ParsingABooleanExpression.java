package KunalKushwaha.Assignments.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingABooleanExpression {
    String boolCal(String a, String b, String operation){
        if (operation.equals("|")) {
            // OR → true if either is true
            if (a.equals("t") || b.equals("t")) return "t";
        } else if (operation.equals("&")) {
            // AND → true only if both are true
            if (a.equals("t") && b.equals("t")) return "t";
        } else if (operation.equals("!")) {
            // NOT → invert single value
            return a.equals("t") ? "f" : "t";
        }
        return "f";
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') continue;

            if (ch == ')') {
                List<String> vals = new ArrayList<>();
                while (st.peek() != '(') {
                    vals.add(st.pop() + "");
                }
                st.pop(); // remove '('
                char op = st.pop(); // operator
                System.out.println(vals + " " + op);
                String res = vals.get(vals.size() - 1);
                if (op == '!') {
                    res = boolCal(res, "", "!");
                } else {
                    // evaluate all vals for '&' or '|'
                    for (int i = vals.size() - 2; i >= 0; i--) {
                        res = boolCal(res, vals.get(i), op + "");
                    }
                }
                st.push(res.charAt(0));
            } else {
                st.push(ch);
            }
        }

        return st.pop() == 't';
    }
    public static void main(String[] args) {
        System.out.println(new ParsingABooleanExpression().parseBoolExpr("|(&(t,f,t,!(&(|(f,f,f,f)))),t)"));
    }
}
