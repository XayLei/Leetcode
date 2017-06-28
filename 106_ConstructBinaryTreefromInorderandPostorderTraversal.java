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
	//��������ȫ�ֱ����������Ͳ��÷ŵ����������д�����
    int inEnd;   //���������������һλ����
    int postEnd; //���������������һλ����

    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
    	if (postEnd < 0) { //������������û��Ԫ��ʱ������null
		    return null;
	    }
	
	    // create root node
	    TreeNode root = new TreeNode(postorder[postEnd--]);
	
	    // ������������������һλ����ڵ㲻��ȣ�˵����������������
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