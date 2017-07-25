//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
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