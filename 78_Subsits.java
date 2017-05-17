public class Solution {
	/*
	求一个数组集合的所有子集，包括空集和本身
	*/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<Integer>(),nums,0);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> li, int[] nums, int start){
        list.add(new ArrayList<>(li));  //第一次进入这个方法时，这行会先加入空集
        for(int i=start;i<nums.length;i++){
            li.add(nums[i]);
            backtrack(list,li,nums,i+1);  //例如当i=0时，这个递归就会把所有包含1的子集全部
            li.remove(li.size()-1);
        }
    }
}