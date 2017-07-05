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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> sonList = new LinkedList<>();
        help(root, sum, list, sonList);
        return list;
    }
    
    public void help(TreeNode root,int sum, List<List<Integer>> list, List<Integer> sonList){
        if(root == null) return;  //������Ҷ�ڵ�ʱֱ�ӷ���
        
        sonList.add(new Integer(root.val));
        if(root.left == null && root.right == null && root.val == sum){  //���ڵ�ΪҶ�ڵ���Ŀ��ʣ�����뵱ǰֵ��ͬ
            list.add(new LinkedList(sonList)); //����Ӵ���Ӽ�
            sonList.remove(sonList.size()-1); //���˵���һ���ڵ�
            return; //ֱ�ӷ���
        }else{
            help(root.left, sum-root.val, list, sonList);  //û�е���Ҷ�ڵ�ʱ�������ݹ�����
            help(root.right, sum-root.val, list, sonList); //û�е���Ҷ�ڵ�ʱ�������ݹ�����
        }
        sonList.remove(sonList.size()-1);
    }
}