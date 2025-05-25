//https://leetcode.com/problems/richest-customer-wealth/

public class RichestCustomerWealth {
    //1672
    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int[] rows : accounts){
            int sum = 0;
            for(int element : rows){
                sum += element;
            }
            max = (sum>max)? sum : max;
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] accounts = {
            {1,5},
            {7,3},
            {3,5}
        };

        System.out.println(maximumWealth(accounts));

    }
    
}
