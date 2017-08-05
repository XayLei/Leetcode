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
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot==null)
            return result;
        
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(null); //标识分层
        que.addLast(pRoot); //添加到最右端，LinkedList的右端为尾，左端为头，这样，当正序遍历的时候就是从左向右，逆序时反之。
        boolean leftToRight = true; //标识从左向右打印
        while(que.size()!=1){
            TreeNode temp = que.removeFirst();
            if(temp==null){
                Iterator<TreeNode> iter = null;
                if(leftToRight){
                    iter = que.iterator();//正序遍历，从左到右
                }else{
                    iter = que.descendingIterator();//逆序遍历，从右到左
                }
                leftToRight = !leftToRight;
                while(iter.hasNext()){
                    TreeNode te = iter.next();
                    list.add(te.val);
                }
                result.add(new ArrayList<Integer>(list));
                list.clear();
                que.addLast(null);
                continue;//添加下一层节点，不加这句，则当队列中null元素时，也会进行左右节点的判断。
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