/*
����˼·�����Ǹ������������㷨�ĸ��Ӷȣ��ռ���˷�

쳲���������:0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233����

����õݹ�Ļ�������f(n)=f(n-1)+f(n-2),���������ջ�����
*/

 public class Solution {
    public int Fibonacci(int n) {
		int fn1 = 1,fn2=1;
        if(n<=0) return 0;
        if(n==1 || n==2) return 1;
        while(n-->2){
            fn1 += fn2;
            fn2 = fn1-fn2;
        }
        return fn1;
    }
}