class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
       val = x;
    }
}

//Recursive Method
List<Integer> postOrderTravesal(TreeNode root){
    List<Integer> result = new ArrayList<>();
    if(root == null) return result;
    
    result.addAll(postOrderTravesal(root.left));
    result.addAll(postOrderTravesal(root.right));
    result.add(root.val);
    
    return result;
}

//Non-recursive Method
List<Integer> postOrderTravesal(TreeNode root){
    List<Integer> result = new ArrayList<>();
    if(root == null){
       return result;
    }
    
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    TreeNode last = null;
    while(p!=null || !stack.isEmpry()){
       if(p!=null){
           stack.push(p);
           p = p.left;
       }else{
           //last left subtree's root
           TreeNode peek = stack.peek();
           if(peek.right != null && last != peek.right){
              p = peek.right;
           }else{
              peek = stack.pop();
              result.add(peek.val);
              last = peek;
           }
       }
    }
    return result;
}
