package Striver.GreedyAlgorithm.Leetcode;

public class LemonadeChange {
    //Simple greedy algo
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill : bills){
            if(bill == 5) five++;
            else if(bill == 10){
                if(five > 0){
                    five--;
                    ten++;
                }else
                    return false;
            }
            else{
                //Keeping 5 as it's the imp change
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
