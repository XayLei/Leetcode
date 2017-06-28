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
	//定义两个全局变量，这样就不用放到方法参数中传递了
    int inEnd;   //中序遍历数组的最后一位索引
    int postEnd; //后序遍历数组的最后一位索引

    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
    	if (postEnd < 0) { //当后序数组中没有元素时，返回null
		    return null;
	    }
	
	    // create root node
	    TreeNode root = new TreeNode(postorder[postEnd--]);
	
	    // 如果中序遍历数组的最后一位与根节点不相等，说明二叉树有右子树
	    if (inorder[inEnd] != root.val) {
	    	root.right = buildTree(inorder, postorder, root);
    	}
	
    	inEnd--;
	
    	// if left node exist, create left subtree
    	if ((end == null) || (inorder[inEnd] != end.val)) {
    		root.left = buildTree(inorder, postorder, end);
    	}
	
    	return root;
        }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
	    inEnd = inorder.length - 1;
    	postEnd = postorder.length - 1;
	
    	return buildTree(inorder, postorder, null);
    }
}