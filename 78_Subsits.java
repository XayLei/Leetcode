public class Solution {
	/*
	��һ�����鼯�ϵ������Ӽ��������ռ��ͱ���
	*/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<Integer>(),nums,0);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> li, int[] nums, int start){
        list.add(new ArrayList<>(li));  //��һ�ν����������ʱ�����л��ȼ���ռ�
        for(int i=start;i<nums.length;i++){
            li.add(nums[i]);
            backtrack(list,li,nums,i+1);  //���統i=0ʱ������ݹ�ͻ�����а���1���Ӽ�ȫ��
            li.remove(li.size()-1);
        }
    }
}