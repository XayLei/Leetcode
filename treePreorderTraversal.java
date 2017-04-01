//定义树的节点类
class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x){
         val = x;
     }
}

//use recursive method to preorder traversal
List<Integer> preorderTraversal(TreeNode root){
     List<Integer> result = new ArrayList<>();
     if(root == null) return result;
     
     result.add(root.val);
     result.addAll(preorderTraversal(root.left));
     result.addAll(preorderTraversal(root.right));
     reutrn result;
}


//use Non-recursive
List<Integer> preorderTraversal(TreeNode root){
     List<Integer> result = new ArrayList<>();
     if(root == null) return result;
     
     Stack<TreeNode> stack = new Stack<>();
     stack.push(root);
     while(!stack.isEmpty()){
         TreeNode node = stack.pop();
         result.add(node.val);
         if(node.right != null){
              stack.push(node.right);
         }
         if(node.left != null){
              stack.push(node.left);
         }
     }
     return result;
}
