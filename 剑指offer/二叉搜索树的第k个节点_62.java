import java.util.Stack;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
非递归的中序遍历实现
*/
public class Solution {
    TreeNode KthNode(TreeNode root, int k)
    {
        if(root==null || k==0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = root;
        do{
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                count++;
                if(count==k)
                    return node;
                node = node.right;
            }
        }while(node!=null || !stack.isEmpty());
        return null;
    }
}