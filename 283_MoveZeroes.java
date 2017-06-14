public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0) return;
        
        int insertNum=0;
        for(int num : nums){  //遍历数组
            if(num!=0) nums[insertNum++] = num;  //如果元素不为0，则按顺序插入到数组中
        }
        
        while(insertNum<nums.length){ //最后，不为0的元素全部按顺序插入到了数组前面，此时如果insertNum小于数组长度，则在后面全部补0
            nums[insertNum++] = 0;
        }
    }
}