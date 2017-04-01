class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

//Recursive Method
List<Integer> inOrderTraversal(TreeNode root){
     List<Integer> result = new ArrayList<>();
     if(root == null){
        return result;
     }
     
     result.addAll(inOrderTraversal(root.left));
     result.add(root.val);
     result.addAll(inOrderTraversal(root.right));
     
     return result;
}

//Non-Recursive Method
List<Integer> inOrderTraversal(TreeNode root){
   List<Integer> result = new ArrayList<>();
   if(root == null){
       reuturn result;
   }
   
   Stack<TreeNode> stack = new Stack<>();
   TreeNode p = root;
   while(p!=null || !stack.isEmpty()){
       if(p!=null){
           stack.push(p);
           p = p.left;
       }else{
           p = stack.pop();
           result.add(p.val);
           p = p.right;
       }
   }
   return result;
}
