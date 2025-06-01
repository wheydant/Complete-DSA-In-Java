public class StackAndQueue {
    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(32);
        stack.push(33);
        stack.push(5);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(3);
        queue.add(6);
        queue.add(5);
        queue.add(19);
        queue.add(1);

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
        deque.add(3);
        deque.addFirst(2);
        deque.addLast(5);

        deque.removeFirst();
        deque.removeLast();
    }
}
