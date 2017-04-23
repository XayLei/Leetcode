class TreeNode{
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x){
     val = x;
   }
}

public class Solution{
   
   int vilt = 0;    //定义一个全局变量，这个全局变量不能声明为类变量，否则不能AC，具体原因并不知道
   
   public int findTilt(TreeNode root){
      postorder(root);
      return vilt;
   }
   
   public int postorder(TreeNode root){
      if(root == null)
         return 0;   //如果节点为NULL则返回0
         
      int leftsum = postorder(root.left);   //递归求左子树的和
      int rightsum = postorder(root.right);
      
      tilt += Math.abs(leftsum - rightsum);  //从下往上求tilt数
      
      return leftsum + rightsum + root.val;   //返回该节点左右子树和自身节点值得和，就是用的这个值，才可以递归求父节点的的左子树和或右子树和
   }
}
