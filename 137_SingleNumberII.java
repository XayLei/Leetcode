public class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int result = 0;
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
        for(int i = 3; i<nums.length-3; i++){
            if(nums[i] > nums[i-1] && nums[i] < nums[i+1]){
                result = nums[i];
                break;
            }
        }
        return result;
    }
}

public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}