package KunalKushwaha.Assignments.StackAndQueue;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // <= is important as there can be multiple least push 0 1 0 so while pop we shouldn't pop 0 stored for initial value
        if(minStack.size() == 0 || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == minStack.peek()) 
            minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
