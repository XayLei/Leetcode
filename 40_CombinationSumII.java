public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates,0,target,result,path);
        return result;
    }
    
    public void dfs(int[] can,int cur,int target,List<List<Integer>> res, List<Integer> path){
        if(target==0){ //���ﵽĿ��ʱ����Ҫ��Ŀ��·����ʱ����
            res.add(new ArrayList(path));
            return;
        }
        if(target<0) return;
        for(int i = cur; i<can.length; i++){
            if(i>cur && can[i]==can[i-1]) continue;  //�������г����ظ�����ʱ��ֱ������������һ��ѭ��
            path.add(path.size(),can[i]);
            dfs(can,i+1,target-can[i],res,path);
            path.remove(path.size()-1);
        }
    }
}