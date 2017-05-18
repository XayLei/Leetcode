public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);  //数组中有重复元素，所以排序
        backtrack(list,new ArrayList<Integer>(),nums,new boolean[nums.length]); 
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> li, int[] nums,boolean[] used){  //布尔数组用于标记重复元素或是已经用过的数组元素
        if(li.size()==nums.length){
            list.add(new ArrayList<>(li));
            return;
        }else{
            for(int i=0; i<nums.length; i++){
                if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;  
				//例如[1,1,3]，这里在第一次得出结果[1(0),1(1),3(2)]时，不会跳过循环，当第二次出现[1(1),1(0),3(2)]时，就会直接进行下一次循环
                used[i]=true;
                li.add(nums[i]);
                backtrack(list,li,nums,used);
                used[i]=false;
                li.remove(li.size()-1);
            }
        }
    }
}