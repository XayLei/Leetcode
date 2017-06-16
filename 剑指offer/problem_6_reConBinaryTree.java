/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 ����֪��������ǰ��������������������£���ԭ������
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reCon(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    
    private TreeNode reCon(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if(startPre>endPre || startIn>endIn) return null;
        
        TreeNode root = new TreeNode(pre[startPre]);
        
        for(int i=startIn;i<=endIn;i++){ //�����������飬
            if(in[i] == pre[startPre]){ //��������е�ĳ��Ԫ����ǰ���е�ĳ��Ԫ����ȣ������Ԫ��Ϊ��
                root.left = reCon(pre,startPre+1,endPre+i-startIn,in,startIn,i-1); //�ݹ�������ؼ��ѵ��Ǳ߽��ȷ��
                root.right = reCon(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }
}