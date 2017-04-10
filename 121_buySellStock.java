//如果这里的遍历循环应用for..each循环的话，在测试最后一个大数据时就会超出时间限制，所以这里要使用普通的for循环

public class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        
        for(int c = 0; c < prices.length; c++){
            firstBuy = Math.max(firstBuy , -prices[c]);
            firstSell = Math.max(firstSell , firstBuy + prices[c]);
        }
        
        return firstSell;
    }
}
