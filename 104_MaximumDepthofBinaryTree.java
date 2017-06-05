public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
}

public class Solution{
	public int maxDepth(TreeNode root){
		return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1;
	}
}

/*
递归计算二叉树的最大深度，每递归一次，则表明树的深度加1，叶节点后空节点的遍历返回0，在叶节点上的递归正好返回1，
每到一个父节点，取最大深度作为递归返回。

这题做的时候不能想复杂了，一行就可以解决。

*/