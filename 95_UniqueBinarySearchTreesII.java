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
		
		//�������Խ�磬���LIST���null��������
		if(start>end){
			list.add(null);
			return list;
		}
		
		//���start��end��ͬ������start�����µĽڵ㣬��ӽ�list������
		if(start==end){
			list.add(new TreeNode(start));
			return list;
		}
		
		List<TreeNode> left,right;  //���������������ڴ洢��������
		for(int i=start; i<=n; i++){
			left = gen(start,i-1);  //���õݹ��������������
			right = gen(i+1,end);  //���õݹ��������������
			
			for(TreeNode lnode : left){  //���������������еĽڵ�
				for(TreeNode rnode : right){  //���������������еĽڵ�
					TreeNode root = new TreeNode(i);  //��iΪ���ڵ�
					root.left = lnode;  
					root.right = rnode;
					list.add(root);
				}
			}
		}
		
		return list;
	}
}