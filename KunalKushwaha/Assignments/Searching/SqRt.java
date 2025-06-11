package KunalKushwaha.Assignments.Searching;

public class SqRt {
    public static int mySqrt(int x) {
        if(x == 0)return 0;
        long left = 1;
        long right = x;
        while(left <=right){
            long mid = left + (right - left)/2;
            if((int)mid*mid == x)return (int) mid;
            else if(mid*mid < x) left = mid + 1;
            else right = mid - 1;

            System.out.println("Mid " +mid +" mid*mid "+mid*mid + " left "+left+" right "+ right);
        }
        return (int)right;
    }
    public static void main(String[] args) {
        
        // System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(8));

    }
}
