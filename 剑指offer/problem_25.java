import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        if(root==null) return re;
        ArrayList<Integer> li = new ArrayList<>();
        help(re,li,target,root);
        return re;
    }
    
    public void help(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> li, int target, TreeNode root){
        if(root==null) return;
        
        li.add(root.val);
        if(root.right==null && root.right==null && root.val==target){
            re.add(new ArrayList<>(li));
            li.remove(li.size()-1);
            return;
        }else{
            help(re,li,target-root.val,root.left);
        	help(re,li,target-root.val,root.right);
        }
        li.remove(li.size()-1);
    }
}