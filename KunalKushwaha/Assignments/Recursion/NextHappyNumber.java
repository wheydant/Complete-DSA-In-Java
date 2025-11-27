package KunalKushwaha.Assignments.Recursion;

public class NextHappyNumber {
	boolean isHappy(int n){
		if(n == 1 || n == 7) return true;
		int sum = n;

		while(sum > 9){
			int curr = sum;
			sum = 0;
			while(curr > 0){
				int d = curr%10;
				sum += d*d;
				curr /= 10;
			}

			if(sum == 1) return true;
		}
		if(sum == 7) return true;
		return false;
	}
	int nextHappy(int n){
		int next = n + 1;
		int res = next;
		while (true) { 
			if(isHappy(next))
				return next;
			next++;
			res = next;
		}
	}
	public static void main(String[] args) {
		System.out.println(new NextHappyNumber().nextHappy(10));
	}
}
