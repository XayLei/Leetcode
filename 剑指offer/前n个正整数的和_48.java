/*
��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
*/

 class Solution {
    public int Sum_Solution(int n) {
        if(n==1) return 1;
        return n + Sum_Solution(n-1);
    }
}