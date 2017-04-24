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
		//这是一种利用链表数据结构的非递归的二叉树后序遍历方法
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
			//这个算法的重点就是这里，利用链表的addfirst方法，将每一个根节点的值插入到
			//链表的顶端，也就是通常理解的最后面，因为后序遍历的顺序是左-右-中，所以这个
			//算法其实是反着来遍历的，最后的结果从通常的正向角度看就是后序遍历的结果
			//这个方法既没有用递归增加内存使用量，还巧妙的利用了链表数据结构的特性，使整个
			//算法非常好理解
            list.addFirst(cur.val);
			//从后向前看的话，左子树要后于右子树，根据栈先进后出的结构特点
			//这里先将左子节点压入栈中
            if(cur.left != null){
                stack.push(cur.left);
            }
			//然后再压入右子节点，这样往出弹的时候就先是右子节点，接着才是左子节点
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        return list;
    }
}