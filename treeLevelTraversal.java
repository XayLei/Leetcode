class TreeNode{
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x){
      val = x;
   }
}

List<Integer> levelTraversal(TreeNode root){
   List<Integer> result = new ArrayList<>();
   if(root == null){
      return result;
   }
   
   LinkedList<TreeNode> queue = new LinkedList<>();
   queue.addLast(root);
   while(queue,size() != 0){
      TreeNode node = queue.pollFirst();
      result.add(node.val);
      if(node.left != null){
         queue.addLast(node.left);
      }
      if(node.right != null){
         queue.addLast(node.right);
      }
   }
   
   return result;
}
