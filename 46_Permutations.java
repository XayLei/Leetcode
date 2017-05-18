/*
求一个数组的全排列，输出所有可能的结果
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),nums);
        return list;
    }
    
	//经典的backtrack问题
    public void backtrack(List<List<Integer>> list, List<Integer> li, int[] nums){
        if(li.size()==nums.length){
            list.add(new ArrayList<>(li));
            return;
        }else{
            for(int i=0; i<nums.length; i++){ //每次都要遍历数组中的所有元素
                if(li.contains(nums[i])) continue;  //如果链表中已经有数组中的某个元素，则直接跳过，进入下一次循环
                li.add(nums[i]);
                backtrack(list,li,nums);
                li.remove(li.size()-1);
            }
        }
    }
}