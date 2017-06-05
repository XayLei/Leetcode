/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        //如果最终的高度值不为-1，则说明树满足平衡树条件，返回true，否则返回false
        return height(root) != -1;
    }
    
    public int height(TreeNode root){
		//如果节点为空，则返回高度0
        if(root==null) return 0;
		//左子树的最大高度
        int lh = height(root.left);
		//如果左子树的高度为-1，则说明左子树不满足平衡树条件，直接返回-1，结束递归
        if(lh==-1) return -1;
		//同上
        int rh = height(root.right);
        if(rh==-1) return -1;
		//当某个父节点的左右子树满足平衡树条件时，这时判断这个父节点树是否是平衡树，如果是，则继续向下执行
        if(lh-rh < -1 || lh-rh > 1) return -1;
		//root这颗子树为平衡树，返回这棵树的最大深度
        return Math.max(lh,rh)+1;
    }
}