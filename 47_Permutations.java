public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);  //���������ظ�Ԫ�أ���������
        backtrack(list,new ArrayList<Integer>(),nums,new boolean[nums.length]); 
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> li, int[] nums,boolean[] used){  //�����������ڱ���ظ�Ԫ�ػ����Ѿ��ù�������Ԫ��
        if(li.size()==nums.length){
            list.add(new ArrayList<>(li));
            return;
        }else{
            for(int i=0; i<nums.length; i++){
                if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;  
				//����[1,1,3]�������ڵ�һ�εó����[1(0),1(1),3(2)]ʱ����������ѭ�������ڶ��γ���[1(1),1(0),3(2)]ʱ���ͻ�ֱ�ӽ�����һ��ѭ��
                used[i]=true;
                li.add(nums[i]);
                backtrack(list,li,nums,used);
                used[i]=false;
                li.remove(li.size()-1);
            }
        }
    }
}