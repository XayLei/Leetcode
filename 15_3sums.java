//这个运行速度比下面的更快
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		for(int k =0; k<nums.length; k++){
			if(nums[k]>0) break;
            //注意这里，这里是避免重复列表的关键			
            if(k>0 && nums[k]==nums[k-1]) continue;
			int target = 0 - nums[k];
			int i = k+1;
			int j = nums.length-1;
			while(i<j){
				if(nums[i]+nums[j]==target){
					List<Integer> li = new ArrayList<>();
					li.add(nums[k]);
					li.add(nums[i]);
					li.add(nums[j]);
					list.add(li);
                    //这里也是为了避免重复元素					
                    while(i<j && nums[i]==nums[i+1]) ++i;
					while(i<j && nums[j]==nums[j-1]) --j;
					++i;
					--j;
				}else if(nums[i]+nums[j] < target) ++i;
				else --j;
			}
		}
		return list;
    }
}


//这是另一种方法
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return results;
        }
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate triples with the same first numebr
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            
            twoSum(nums, left, right, target, results);
        }
        
        return results;
    }
    
    public void twoSum(int[] nums,
                       int left,
                       int right,
                       int target,
                       List<List<Integer>> results) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
                
                left++;
                right--;
                // skip duplicate pairs with the same left
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                // skip duplicate pairs with the same right
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
