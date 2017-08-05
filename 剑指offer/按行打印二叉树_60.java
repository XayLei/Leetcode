import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/*
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
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot==null)
            return result;
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(null);
        que.add(pRoot);
        while(que.size()!=1){
            TreeNode temp = que.removeFirst();
            if(temp == null){
                Iterator<TreeNode> iter = que.iterator();
                while(iter.hasNext()){
                    TreeNode te = iter.next();
                    list.add(te.val);
                }
                result.add(new ArrayList<Integer>(list));
                list.clear();
                que.addLast(null);
                continue;
            }
            if(temp.left!=null){
                que.addLast(temp.left);
            }
            if(temp.right!=null){
                que.addLast(temp.right);
            }
        }
        return result;
    }
}