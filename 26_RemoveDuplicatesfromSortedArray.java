public class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1, n=nums.length;
        if(n < 2) return n;  //如果数组的长度小于2，则直接返回数组的长度，不可能存在重复的元素
        for(int i=1;i<n;i++){  //循环遍历从数组的第二个元素开始
            if(nums[i]!=nums[i-1]){
                nums[count++] = nums[i]; //先将不重复的元素向前移动，然后更新count的值
            }
        }
        return count;
    }
}