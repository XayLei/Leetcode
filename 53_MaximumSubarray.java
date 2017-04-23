//此题求的是子序列最大的和，而不是拥有最大和的子序列
//利用DP求解，关键在于寻找状态转移方程
public class Solution{
  public int maxSubArray(int[] nums){
     int[] dp = new int[nums.length];  //dp[i]就代表数组0到i中的所有子序列中最大的和
     dp[0] = nums[0];
     int max = dp[0];
     for(int i =1; i<dp.length; i++){
        dp[i] = nums[i] + (dp[i-1]<0 ? 0 : dp[i-1]);
        max = Math.max(max, dp[i]);
     }
        
     return max;
  }
}
