public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0) return false;
        boolean re = help(sequence, 0, sequence.length);
        return re;
    }
    
    public boolean help(int[] sequence,int start,int end){
        if(start>=end) return true;
        for(;start<end-1;start++){ //�ҵ������ҽڵ�����
            if(sequence[start]>sequence[end-1])
                break;
        }
        
        for(int j = start; j<end-1;j++){ //�ж����е��ҽڵ��Ƿ񶼴��ڸ��ڵ�
            if(sequence[j] < sequence[end-1])
                return false;
        }
        
        boolean left = true;
        if(start>0) //�ж��������Ƿ��Ƕ����ѯ��
            left = help(sequence,0,start);
        
        boolean right = true;
        if(start<end-1){ //�ж��������Ƿ��Ƕ����ѯ��
            right = help(sequence,start,end - 1);
        }
        return (left && right);
    }
}