/*
��������Լ��ɼ�Խ��Խ���ӡ����ȣ����ǰ����е�case�ֿ����������rating����ͼ����ôֻ������case: 
1. ������num[i] = num[i-1]+1; 
2. �ݼ���num[i] = num[i+1] +1;

�᲻������һ��δ�����ֵ�����ᣬ��Ϊ���ǿ��Զ�����num�ȳ�ʼ��Ϊ1�� 
��Ȼ�������ֹ��ɣ����ǾͿ��������α����� 
�����ң������������е����ĵ�ȷ��ֵ�� 
���ҵ������еݼ��ĵ�ȷ����ֵ�� 
ת�۵��أ�ȡ���ߵ����ֵ��
*/

public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
        
        int n = ratings.length;
        int[] re = new int[n];
        re[0] = 1;
        for(int i = 1; i<n; i++){
            re[i] = 1;
            if(ratings[i] > ratings[i-1]){
                re[i] = re[i-1] + 1;
            }
        }
        
        for(int j = n-2; j>=0; j--){
            if(ratings[j] > ratings[j+1]){
                re[j] = Math.max(re[j], re[j+1]+1);
            }
        }
        
        int count = 0;
        for(int m=0;m<n;m++){
            count += re[m];
        }
        
        return count;
    }
}