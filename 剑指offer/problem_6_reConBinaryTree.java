/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 在已知二叉树的前序遍历和中序遍历的情况下，复原二叉树
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reCon(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    
    private TreeNode reCon(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if(startPre>endPre || startIn>endIn) return null;
        
        TreeNode root = new TreeNode(pre[startPre]);
        
        for(int i=startIn;i<=endIn;i++){ //遍历中序数组，
            if(in[i] == pre[startPre]){ //如果中序中的某个元素与前序中的某个元素相等，则这个元素为根
                root.left = reCon(pre,startPre+1,endPre+i-startIn,in,startIn,i-1); //递归遍历，关键难点是边界的确定
                root.right = reCon(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }
}