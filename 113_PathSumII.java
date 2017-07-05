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
        if(root == null) return;  //遍历到叶节点时直接返回
        
        sonList.add(new Integer(root.val));
        if(root.left == null && root.right == null && root.val == sum){  //当节点为叶节点且目标剩余数与当前值相同
            list.add(new LinkedList(sonList)); //则添加达标子集
            sonList.remove(sonList.size()-1); //回退到上一个节点
            return; //直接返回
        }else{
            help(root.left, sum-root.val, list, sonList);  //没有到达叶节点时，继续递归深搜
            help(root.right, sum-root.val, list, sonList); //没有到达叶节点时，继续递归深搜
        }
        sonList.remove(sonList.size()-1);
    }
}