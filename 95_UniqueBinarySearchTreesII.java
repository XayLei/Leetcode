public class Solution{
	public List<TreeNode> generateTrees(int n){
		
		List<TreeNode> list = new ArrayList<>();
        if(n<1){
            return list;
        }
		
		return gen(1,n);
	}
	
	public List<TreeNode> gen(int start, int end){
		List<TreeNode> list = new ArrayList<>();
		
		//如果索引越界，则给LIST添加null，并返回
		if(start>end){
			list.add(null);
			return list;
		}
		
		//如果start和end相同，则以start创建新的节点，添加进list并返回
		if(start==end){
			list.add(new TreeNode(start));
			return list;
		}
		
		List<TreeNode> left,right;  //创建左右链表用于存储左右子树
		for(int i=start; i<=n; i++){
			left = gen(start,i-1);  //利用递归添加所有左子树
			right = gen(i+1,end);  //利用递归添加所有右子树
			
			for(TreeNode lnode : left){  //遍历左子树中所有的节点
				for(TreeNode rnode : right){  //遍历右子树中所有的节点
					TreeNode root = new TreeNode(i);  //以i为根节点
					root.left = lnode;  
					root.right = rnode;
					list.add(root);
				}
			}
		}
		
		return list;
	}
}