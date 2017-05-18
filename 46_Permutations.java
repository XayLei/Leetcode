/*
��һ�������ȫ���У�������п��ܵĽ��
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),nums);
        return list;
    }
    
	//�����backtrack����
    public void backtrack(List<List<Integer>> list, List<Integer> li, int[] nums){
        if(li.size()==nums.length){
            list.add(new ArrayList<>(li));
            return;
        }else{
            for(int i=0; i<nums.length; i++){ //ÿ�ζ�Ҫ���������е�����Ԫ��
                if(li.contains(nums[i])) continue;  //����������Ѿ��������е�ĳ��Ԫ�أ���ֱ��������������һ��ѭ��
                li.add(nums[i]);
                backtrack(list,li,nums);
                li.remove(li.size()-1);
            }
        }
    }
}