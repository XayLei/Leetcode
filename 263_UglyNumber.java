public class Solution {
    public boolean isUgly(int num) {
        // if(num<0) return false;
        // if(num==1) return true;
        // while(num>0){
        //     if(num%2==0){
        //         num = num/2;
        //         if(num==1)  return true;
        //     }else if(num%3==0){
        //         num=num/3;
        //         if(num==1)  return true;
        //     }else if(num%5==0){
        //         num=num/5;
        //         if(num==1)  return true;
        //     }
        // }
        // return false;
		/*
		����ע�͵����Լ�д�ģ���ʱ�ˣ�so sad������
		������һλ���ţ��д�ģ����Ǻ�����������
		*/
        if(num>0){
            for(int i : new int[]{2,3,5}){
                while(num%i==0){
                    num /= i;
                }
            }
        }
        return num==1;
    }
}