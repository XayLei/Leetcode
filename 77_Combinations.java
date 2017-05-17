public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),1,n,k);
        return list;
    }
    /*
	回溯方法，类似的还有78题
	**/
    public void backtrack(List<List<Integer>> list,List<Integer> li,int start,int end,int k){
        if(li.size()==k){
            list.add(new ArrayList<>(li));
            return;
        }
        
        for(int i=start;i<=end;i++){
            li.add(i);
            backtrack(list,li,i+1,end,k);
            li.remove(li.size()-1);
        }
    }
}