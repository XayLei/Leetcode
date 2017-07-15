public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0) return false;
        boolean re = help(sequence, 0, sequence.length);
        return re;
    }
    
    public boolean help(int[] sequence,int start,int end){
        if(start>=end) return true;
        for(;start<end-1;start++){ //找到树的右节点索引
            if(sequence[start]>sequence[end-1])
                break;
        }
        
        for(int j = start; j<end-1;j++){ //判断所有的右节点是否都大于根节点
            if(sequence[j] < sequence[end-1])
                return false;
        }
        
        boolean left = true;
        if(start>0) //判断左子树是否是二叉查询树
            left = help(sequence,0,start);
        
        boolean right = true;
        if(start<end-1){ //判断右子树是否是二叉查询树
            right = help(sequence,start,end - 1);
        }
        return (left && right);
    }
}