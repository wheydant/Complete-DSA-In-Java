package KunalKushwaha.Assignments.Bitwise;

public class DivideTwoNumber {
    public int divide(int dividend, int divisor) {
        boolean sign = true;
        if(dividend < 0 || divisor < 0){
            if(dividend < 0 && divisor < 0){
				//Change sign
                sign = true;
            }
            else if(divisor > 0){
				//Keep ans negative
                sign = false;
                divisor *= -1;
            }else if(dividend > 0){
				//Keep ans negative
                sign = false;
                dividend *= -1;
            }
        }else{
			//Change sign
			sign = true;
			dividend *= -1;
			divisor *= -1;
		}
        int ans = 0;
		// System.out.println(dividend + " "+ divisor);
        //Keeping everything negative as -2^31 is greater than 2^31
        while(dividend <= divisor){
            int count = 0;
            while(dividend <= (divisor << (count + 1))){
				// System.out.println(divisor << count);
                count++;
            }
            ans -= 1<<count;
            dividend -= divisor<<count;
        }

        if(sign && ans == Integer.MIN_VALUE){
			return Integer.MAX_VALUE;
		}

		return (sign)? -1*ans:ans;
    }
	public static void main(String[] args) {
		// System.out.println(new DivideTwoNumber().divide(10, 3));
		// System.out.println(new DivideTwoNumber().divide(7, -3));
		System.out.println(new DivideTwoNumber().divide(-1, 1));
	}
}
