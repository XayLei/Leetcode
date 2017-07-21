public class Solution {
    private boolean isBal = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        depth(root);
        return isBal;
    }
    public int depth(TreeNode root){
        if(root==null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        
        if(Math.abs(left-right)>1)
            isBal = false;
        
        return left > right ? left+1 : right+1;
    }
}