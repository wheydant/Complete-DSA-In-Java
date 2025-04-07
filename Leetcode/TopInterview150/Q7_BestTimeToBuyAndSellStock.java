



public class Q7_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {2, 8, 1, 3};

        System.out.println(maxProfit1(prices));
    }


    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] - prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }
            }
        }

        return maxProfit;
    }

    public static int maxProfit1(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }else if(prices[i] - buy > profit){
                profit = prices[i] - buy;
            }
        }

        

        return profit;
    }
}
