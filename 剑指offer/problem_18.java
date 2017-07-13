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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){ //如果两棵树都为空，则直接返回false
            if(root1.val==root2.val){ //如果根节点相同，则进入查找判断子节点是否相同
                result = help(root1,root2);
            }
            if(!result) result = HasSubtree(root1.left,root2); //当子节点不同时，遍历root1的左子节点
            if(!result) result = HasSubtree(root1.right,root2); //同理
        }
        return result;
    }
    
    public boolean help(TreeNode root1, TreeNode root2){
        if(root2==null) return true;
        if(root1==null) return false;
        if(root1.val != root2.val) return false;
        
        return help(root1.left,root2.left)&&help(root1.right,root2.right);
    }
}