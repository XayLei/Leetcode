/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Recursive Method
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        if(root.left == null && root.right == null && root.val==sum) return true;
        
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}

//Non-recursive
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<Integer> sums = new Stack<>();
        Stack<TreeNode> tree = new Stack<>();
        
        sums.push(sum);
        tree.push(root);
        while(!tree.isEmpty() && root != null){
            TreeNode top = tree.pop();
            int value = sums.pop();
            
            if(top.left==null && top.right==null && top.val==value) return true;
            
            if(top.right != null){
                tree.push(top.right);
                sums.push(value-top.val);
            }
            
            if(top.left != null){
                tree.push(top.left);
                sums.push(value-top.val);
            }
        }
        return false;
    }
}
