/*
问题描述：
	如果我们把二叉树看成一个图，父子节点之间的连线看成是双向的，
	我们姑且定义"距离"为两节点之间边的个数。
	写一个程序求一棵二叉树中相距最远的两个节点之间的距离。

	public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
*/
public class Solution{
	private int maxLen = 0;
	public int findMaxLen(Node root) {  
        if (root == null) {  
            return 0;  
        }  
        if (root.left == null && root.right == null) {  
            return 0;  
        }  
        int leftMaxLen = findMaxLen(root.left) + 1;  
        int rightMaxLen = findMaxLen(root.right) + 1;  
  
        int maxTemp = leftMaxLen + rightMaxLen;  
  
        if (maxTemp > maxLen) {  
            maxLen = maxTemp;  
        }  
  
        return leftMaxLen > rightMaxLen ? leftMaxLen : rightMaxLen;  
    }
}