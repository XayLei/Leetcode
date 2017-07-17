public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length]; //��̬�滮��ʹ���˶���ռ�
        dp[0] = array[0];
        int max = dp[0];
        for(int i=1;i<array.length;i++){
            dp[i] = array[i] + (dp[i-1]>0 ? dp[i-1] : 0);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}