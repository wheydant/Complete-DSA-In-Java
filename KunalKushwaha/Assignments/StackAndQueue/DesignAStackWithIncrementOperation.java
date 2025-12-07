package KunalKushwaha.Assignments.StackAndQueue;

public class DesignAStackWithIncrementOperation {

	CustomStack stack;
    public DesignAStackWithIncrementOperation(int maxSize) {
		stack = new CustomStack(maxSize);
    }
	class CustomStack {
		int[] stack;
		int ptr;

		public CustomStack(int maxSize) {
			stack = new int[maxSize];
			ptr = -1;
		}

		public void push(int x) {
			if(ptr == stack.length - 1) return;
			stack[++ptr] = x;
            // System.out.println(Arrays.toString(stack));
		}

		public int pop() {
            // System.out.println(Arrays.toString(stack));
            if(ptr == -1) return -1;
			return stack[ptr--];
		}

		public void increment(int k, int val) {
			for(int i = 0; i < Math.min(k, ptr + 1); i++){
				stack[i] += val;
			}
            // System.out.println(Arrays.toString(stack));
		}
	}
	public static void main(String[] args) {
		DesignAStackWithIncrementOperation q = new DesignAStackWithIncrementOperation(3);
		CustomStack stk = q.stack;
		stk.push(1);
		stk.push(2);

	}
}
