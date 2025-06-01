import java.util.Stack;

public class ImplementQueueUsingStacks {
    //We can either make efficient Insert or efficient Removal.
    static class MyQueue{
        //Efficient Insert.
        Stack<Integer> stack;
        public MyQueue() {
            stack = new Stack<>();
        }
        
        public void push(int x) {
            stack.push(x);
        }
        
        public int pop() {
            if(empty()){
                return -1;
            }
            Stack<Integer> tempStack = new Stack<>();
            System.out.println(stack);
            while(!empty()){
                int temp = stack.pop();
                tempStack.push(temp);
            }
            int removedEle = tempStack.pop();
            System.out.println(tempStack);
            System.out.println(stack);
            while(!tempStack.empty()){
                int temp = tempStack.pop();
                stack.push(temp);
            }
            System.out.println(stack);

            return removedEle;
        }
        
        public int peek() {
            if(empty()){
                return -1;
            }
            Stack<Integer> tempStack = new Stack<>();
            while(!empty()){
                int temp = stack.pop();
                tempStack.push(temp);
            }
            int topEle = tempStack.peek();
            while(!tempStack.empty()){
                int temp = tempStack.pop();
                stack.push(temp);
            }

            return topEle;
        }
        
        public boolean empty() {
            return stack.empty();
        }
    }

    static class MyQueueEfficient{
        //Efficient Delete and Peek.
        Stack<Integer> stack;
        public MyQueueEfficient() {
            stack = new Stack<>();
        }
        
        public void push(int x) {
            Stack<Integer> tempStack = new Stack<>();

            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
            stack.push(x);
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }
        
        public int pop() {
            return stack.pop();
        }
        
        public int peek() {
            return stack.peek();
        }
        
        public boolean empty() {
            return stack.empty();
        }
    }
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());

        MyQueueEfficient q1 = new MyQueueEfficient();
        q1.push(1);
        q1.push(2);
        System.out.println(q1.peek());
        System.out.println(q1.pop());
    }
}
