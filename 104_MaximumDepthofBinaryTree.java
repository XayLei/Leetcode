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
�ݹ����������������ȣ�ÿ�ݹ�һ�Σ������������ȼ�1��Ҷ�ڵ��սڵ�ı�������0����Ҷ�ڵ��ϵĵݹ����÷���1��
ÿ��һ�����ڵ㣬ȡ��������Ϊ�ݹ鷵�ء�

��������ʱ�����븴���ˣ�һ�оͿ��Խ����

*/