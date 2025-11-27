package KunalKushwaha.Assignments.Recursion;

public class SumOfDigits {
    static int sum_of_digit(int num){
        if(num == 0) return 0;

        return num%10 + sum_of_digit(num/10);
    }
    public static void main(String args[]){
        int num = 12345;
        int result = sum_of_digit(num);
        System.out.println(result);
    }
}
