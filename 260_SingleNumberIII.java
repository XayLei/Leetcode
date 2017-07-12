public class Solution {
    public int[] singleNumber(int[] nums) {
        List<Integer> li = new ArrayList<>();
        if(nums.length == 0) return new int[2];
        Arrays.sort(nums);
        if(nums[0] != nums[1]) li.add(nums[0]);
        if(nums[nums.length-1] != nums[nums.length-2]) li.add(nums[nums.length-1]);
        for(int i = 1; i<nums.length-1; i++){
            if(nums[i] > nums[i-1] && nums[i]<nums[i+1]){
                li.add(nums[i]);
            }
        }
        int[] re = {li.get(0),li.get(1)};
        return re;
    }
}