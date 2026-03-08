package KunalKushwaha.Assignments.StackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {
	public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
		ArrayList<Integer> span = new ArrayList<>();

		Stack<Integer> lastTop = new Stack<>();
		for(int i = 0; i < arr.length; i++){
			while(!lastTop.isEmpty() && arr[lastTop.peek()] <= arr[i]){
				lastTop.pop();
			}

			if(lastTop.isEmpty()){
				span.add(i + 1);
			}else{
				span.add(i - lastTop.peek());
			}
			lastTop.add(i);
		}

		return span;
	}
	public static void main(String[] args) {
		System.out.println(new StockSpanProblem().calculateSpan(new int[]{100, 80, 90, 120}));
		

		System.out.println(new StockSpanProblem().calculateSpan(new int[]{10, 4, 5, 90, 120, 80}));
	}
}
