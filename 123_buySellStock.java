//动态规划问题，将买入卖出分解为4个基本操作，计算每个操作每天可以得到的最大收益

public class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        
        for(int cutPrice : prices){
            firstBuy = Math.max(firstBuy, -cutPrice);
            firstSell = Math.max(firstSell, firstBuy + cutPrice);
            secondBuy = Math.max(secondBuy, firstSell - cutPrice);
            secondSell = Math.max(secondSell, secondBuy + cutPrice);
        }
        
        return secondSell;
    }
}
