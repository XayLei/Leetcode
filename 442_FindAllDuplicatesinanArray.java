public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                li.add(nums[i]);
            }
        }
        return li;
    }
}
/*
这个算法看不懂
编写者的解释：
			when find a number i, flip the number at position i-1 to negative. 
			if the number at position i-1 is already negative, i is the number that occurs twice.
*/
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {  //[4,-3,-2,-7,8,2,3,1]
            int index = Math.abs(nums[i])-1; //index=2-1=1
            if (nums[index] < 0) //nums[1]=3>0
                res.add(Math.abs(index+1));
            nums[index] = -nums[index]; // nums[1]=-3
        }
        return res;
    }
}