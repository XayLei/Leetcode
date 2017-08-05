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
    public int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
  }
    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index>=len)
            return null;
        String[] strArray = str.split(",");
        TreeNode node = null;
        if(!strArray[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strArray[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
  }
}