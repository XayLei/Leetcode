/*
  ���⣺
      ��������digits����һ������������98����digits[0]=9,digits[1]=8
	  ��ĿҪ���Ƕ����������1�󣬷���һ���µ���������
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
		//����������ÿһλ���Ӹ�λ��ʼ
        for(int i=n-1; i>=0; i--){
			//�����IλС��9����ֱ�Ӷ���λ��1������digits����
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            
			//�����iλ����9�����1��Iλ��0��������һλ��1�������λ��1��
            digits[i] = 0;
        }
        
		//��������������0ʱ�����´���һ�����飬���������һλ��Ϊ1��
        int[] newNum = new int[n+1];
        newNum[0] = 1;
        return newNum;
    }
}