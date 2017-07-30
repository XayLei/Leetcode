/*
����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
*/

import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] b = new int[len];
        b[0] = 1;
        for(int i=1;i<len;i++){ //�ⲽ����B[i]=A[0]*A[1]*...*A[i-1]��
            b[i] = b[i-1] * A[i-1];
        }
        int temp = 1; //����ָ��A[i]
        for(int j = len-2;j>=0;j--){//�ⲽ����B[i] *= A[i+1]*...*A[n-1]��
            temp *= A[j+1];
            b[j] *= temp;
        }
        return b;
    }
}