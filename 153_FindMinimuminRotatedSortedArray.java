public class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int start = 0, end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid>0 && nums[mid]<nums[mid-1])
                return nums[mid];
            if(nums[start] <= nums[mid] && nums[mid] > nums[end]){ //抛弃有序的左半部分
                start = mid+1;
            }else{//左半部分无序，则说明最小值还在左半部分，此时更新end值
                end = mid-1;
            }
        }
        return nums[start];
    }
}