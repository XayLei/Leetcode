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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> li = new ArrayList<>();
            int size = q.size();  //通过取出每一层的节点个数来保证每一层节点都可以单独的添加到各自的集合中
            for(int i=0;i<size;i++){ //遍历完成之时，上一层的所有节点已全部添加到集合中，下一层的节点也同时都进入了队列
                TreeNode node = q.poll();
                li.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            list.add(0,li); //在每层遍历结束后，将最终的小集合添加到大集合中，这里如果直接添加，则最终的顺序是从树低到树根。所以需要指定每次添加都添加到开头，这样最终的顺序就是从树根到树底
        }
        return list;
    }
}