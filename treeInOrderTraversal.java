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

//A simple Non-Recursive Method
List<Integer> inOrderTraversal(TreeNode root){
	List<Integer> result = new ArrayList<>();
	Stack<TreeNode> stack = new Stack<>();
	TreeNode cur = root;
	
	//当节点不为null，或者是栈不为空时
	while(cur!=null || !stack.isEmpty()){
		//循环压入每个节点的左节点
		while(cur!=null){
			stack.push(cur);
			cur = cur.left;
		}
		cur = stack.pop();
		result.add(cur.val);
		cur = cur.right;
	}
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
