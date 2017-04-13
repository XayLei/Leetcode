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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null) return list;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> subList = new LinkedList<>();
            int levelSize = que.size();
            for(int i =0 ; i < levelSize; i++){
                TreeNode node = que.poll();
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
                subList.add(node.val);
            }
            list.add(subList);
        }
        return list;
    }
}
