/*
一个有序数组，经过旋转后，用二分查找法求数组中的最小数
数组中可能有重复数字
*/
public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]<nums[end]){ //旋转数组的右半部分，说明最小值可能在mid前面或就是mid
                end = mid;
            }else if(nums[end] < nums[mid]){ //旋转数组的左半部分，mid肯定不是最小值，可能是左半部分后面的值
                start = mid + 1;
            }else{ //当mid与end相等时，不能确定mid是不是最小值，所以end递减
                end--;
            }
        }
        return nums[start];
    }
}