/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

判断一个二叉树是否为镜像二叉树
*/
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
            return true;
        return compare(pRoot.left,pRoot.right);
    }
    
    public boolean compare(TreeNode left,TreeNode right){
        if(left==null) return right==null;
        if(right==null) return false;
        if(left.val!=right.val) return false;
        return compare(left.left,right.right)&&compare(left.right,right.left);
    }
}