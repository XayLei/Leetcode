/*
解释：
     给了一个整型数组，数组中全是非负的整数，每个元素代表在此位置可以跳跃的最大距离
	 判断从数组的首位起跳，是否可以跳到数组的最后一个位置
	 
算法解释：
     设置一个最大值，用于保存在每个位置上可以跳跃的最大距离
	 如果位置的索引i大于max，则说明无法跳到最后一个位置，返回FALSE
	 否则说明i小于max，在最后一个位置前的某个地方的最大跳跃距离超过了最后一个位置的索引
	 返回true

*/

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max=0;
        for(int i=0; i<n; i++){
            if(i>max) return false;
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }
}