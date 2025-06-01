public class Main {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);
        stack.push(32);
        stack.push(45);
        stack.push(5);
        stack.push(9);
        stack.push(18);
        System.out.println(stack);
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());

        System.out.println(stack);

        Stack stack1 = new Stack(2);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.forcePush(4);
        stack1.push(5);

        System.out.println(stack1);


        Queue q1 = new Queue();
        q1.insert(1);
        q1.insert(2);
        q1.insert(3);
        q1.insert(4);

        System.out.println(q1);

        System.out.println(q1.remove());
        System.out.println(q1.remove());

        System.out.println(q1);
    }
}
