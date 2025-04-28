package LeetCode;
/*
 * We can conclude that non happy number follows a cyclic pattern like cyclic linked list thus by using fast and slow pointer we can tackle it.
 */

public class HappyNumber {
    public static boolean isHappy(int n){
        int fast = n;
        int slow = n;
        do { 
            slow = getSq(slow);
            fast = getSq(fast);
            fast = getSq(fast);
            System.out.println("Slow - "+ slow+" Fast - "+fast);
        } while (fast != slow);

        return (fast == 1)? true : false;
    }
    static int getSq(int n){
        int sum = 0;
        while(n != 0){
            int digit  = n % 10;
            sum += digit*digit;
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(isHappy(19));
    }
}
