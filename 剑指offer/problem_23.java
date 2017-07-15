import java.util.ArrayList;
import java.util.LinkedList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> li = new LinkedList<>();
        ArrayList<Integer> re = new ArrayList<>();
        if(root==null) return re;
        li.offer(root);
        while(!li.isEmpty()){
            TreeNode temp = li.poll();
            re.add(temp.val);
            if(temp.left != null) li.offer(temp.left);
            if(temp.right != null) li.offer(temp.right);
        }
        return re;
    }
}