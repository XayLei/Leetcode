/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//已知前序遍历和中序遍历，重建二叉树
 
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(0,0,inorder.length-1,preorder,inorder);
    }
    
    public TreeNode help(int preStart,int inStart,int inEnd,int[] preorder, int[] inorder){
        if(preStart > preorder.length-1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                index = i;
            }
        }
        
        root.left = help(preStart+1,inStart,index-1,preorder,inorder);
        root.right = help(preStart+index-inStart+1,index+1,inEnd,preorder,inorder);
        return root;
    }
}