//采用二分查找法加快查找速度

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length -1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}