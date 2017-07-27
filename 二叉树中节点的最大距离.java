/*
����������
	������ǰѶ���������һ��ͼ�����ӽڵ�֮������߿�����˫��ģ�
	���ǹ��Ҷ���"����"Ϊ���ڵ�֮��ߵĸ�����
	дһ��������һ�ö������������Զ�������ڵ�֮��ľ��롣

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