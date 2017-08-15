public class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start<end){
            int mid = (start + end )/2;
            if(nums[mid+1]>nums[mid]){ //当数组元素小于3时，这样可以避免越界异常
                start = mid+1;
            }else if(nums[mid+1]<nums[mid]){
                end = mid;
            }
        }
        return start;
    }
}