public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        //对数组进行排序
        Arrays.sort(candidates);
        
        help(list, path, candidates, target, 0);
        return list;
    }
    
    public void help(List<List<Integer>> list, List<Integer> path, int[] candidates, int target, int start){
        if(target==0){
            list.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int i = start; i<candidates.length && candidates[i]<=target; i++){
            path.add(candidates[i]);
            help(list, path, candidates, target-candidates[i], i);  //这里将重复的情况也考虑在内了
            path.remove(path.size()-1);  //移除path的最后一个元素
        }
        return;
    }
}