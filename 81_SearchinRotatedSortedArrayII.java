public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return false;
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
                return true;
            if(nums[start]<nums[mid]){ //判断左半部分是否有序
                if(target<nums[start] || target > nums[mid]){ //如果目标数字在有序部分以外
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else if(nums[start]>nums[mid]){ //右半部分为旋转部分
                if(target<nums[mid] || target>nums[end]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{ //出现重复元素时，即nums[start]==nums[mid]
                start++;
            }
        }
        return false;
    }
}