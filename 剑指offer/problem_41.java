//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
//��num1[0],num2[0]����Ϊ���ؽ��
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length==0){
            num1[0]=num2[0]=0;
            return;
        }
        int temp = array[0],j=0;
		
        for(int i=1;i<array.length;i++)
            temp ^= array[i];
		
        for(; j<32; j++){
            if((temp & (1<<j)) != 0)
                break;
        }
		
        for(int i : array){
            if((i & (1<<j)) != 0){
                num1[0] ^= i;
            }else{
                num2[0] ^= i;
            }
        }
    }
}