public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = Solution.startSearch(nums,target);
        if(start==nums.length || nums[start] != target) return new int[]{-1,-1};
        return new int[]{start,Solution.startSearch(nums,target+1)-1}; //确定结尾
    }
    
	//利用二分法查找，数组为有序数组
    private static int startSearch(int[] nums, int target){
        int left = 0,right=nums.length;
        while(left<right){
            int mid = left+(right-left)/2; //取数组中间索引
            if(nums[mid]<target){ //如果数组中间值小于target，则需要将左边界即left右移至mid+1处
                left = mid +1;
            }else{ //否则，将右边界right移至mid处
                right=mid;
            }
        }
        return left;
    }
}

/*
题目要求的复杂度是O（log n）
*/