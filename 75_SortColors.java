/*
	数组中只有0,1,2三种元素
	
	示例：
		输入：{2,1,0,2,0,1,2}
		第一次遍历:i=0,j=0,k=0 ;nums[0] = 2
		第二次遍历:i=0,j=0,k=1; nums[0] = 1 , nums[k=1]=2
		第三次遍历;i=0,j=1,k=2  nums[i = 0] = 0, nums[j=1] =1, nums[k=2] = 2
*/

public class Solution {
    public void sortColors(int[] nums) {
        for(int i=0,j=0,k=0; k<nums.length; k++){
            int temp = nums[k];
            
            //assigning the current as max
            nums[k] = 2;
            
            // if original is less than 2 then it should be 1
            if(temp < 2){
                nums[j] = 1;
                j +=1;
            }
            
            // if original is less than 1 then it should be 0. The above if statement ensures that 1 - index 
            // will always be greater than 0 - index
            if(temp < 1){
                nums[i] = 0;
                i += 1;
            }
        }
    }
}