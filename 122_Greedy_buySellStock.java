//这里使用贪心算法即可，因为买卖的次数没有限定，所以不用像123或121那样进行动态规划

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        for(int i = 0; i < prices.length-1; i++){
            if(prices[i+1] > prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }
        
        return profit;
    }
}
