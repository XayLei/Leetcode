public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return Integer.MIN_VALUE;
        Arrays.sort(nums);
		int n = nums.length;
		//不在这里取绝对值是因为最后要求的是与目标数差值最小的和，而不是与目标数最小的差值
		//求出最小的差值后，返回最小差值与目标数的和，这个和就是差值最小的和，保留了正负号保证了结果的正确性
		int minDiff = nums[0] + nums[1] + nums[2] - target;
		for (int i = 0; i < n - 2; i++) {
			int cur = twoSum(nums, target - nums[i], i + 1);
			if(Math.abs(minDiff)>Math.abs(cur)){
				minDiff = cur;
			}
		}
		return minDiff + target;  
}  
private int twoSum(int[] nums, int target, int start) {
		// TODO Auto-generated method stub
		int minDif = nums[start] + nums[start + 1] - target;
		int left = start;
		int right = nums.length - 1;

		//使用两个指针从两边开始加逼取值
		while (left < right) {
			if(nums[left] + nums[right] == target)
				return 0;
			int diff = nums[left] + nums[right] - target;
			if(Math.abs(minDif)>Math.abs(diff)){
				minDif = diff;
			}
			//注意这里，当左边与右边的和大于target时，需要将右指针左移
			if(nums[left] + nums[right] > target)
				right--;
			else
				left++;
		}
		return minDif;
	}  
}
