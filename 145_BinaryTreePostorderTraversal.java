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
    public List<Integer> postorderTraversal(TreeNode root) {
		//����һ�������������ݽṹ�ķǵݹ�Ķ����������������
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
			//����㷨���ص����������������addfirst��������ÿһ�����ڵ��ֵ���뵽
			//����Ķ��ˣ�Ҳ����ͨ����������棬��Ϊ���������˳������-��-�У��������
			//�㷨��ʵ�Ƿ����������ģ����Ľ����ͨ��������Ƕȿ����Ǻ�������Ľ��
			//���������û���õݹ������ڴ�ʹ��������������������������ݽṹ�����ԣ�ʹ����
			//�㷨�ǳ������
            list.addFirst(cur.val);
			//�Ӻ���ǰ���Ļ���������Ҫ����������������ջ�Ƚ�����Ľṹ�ص�
			//�����Ƚ����ӽڵ�ѹ��ջ��
            if(cur.left != null){
                stack.push(cur.left);
            }
			//Ȼ����ѹ�����ӽڵ㣬������������ʱ����������ӽڵ㣬���Ų������ӽڵ�
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        return list;
    }
}