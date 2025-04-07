

public class Q8_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {6,1,3,2,4,7};

        System.out.println(maxProfit1(prices));
    }
    //Greedy Algo
    public static int maxProfit1(int[] prices) {
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }

      
}
