class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x){
         val = x;
     }
}

//This problem was inspired by a Google interview
public TreeNode invertTree(TreeNode root){
    if(root == null) return null;
    
    root.left = invertTree(root.left);
    root.right = invertTree(root.right);
    
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
    
    return root;
}
