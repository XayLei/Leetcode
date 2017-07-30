/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
*/

import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] b = new int[len];
        b[0] = 1;
        for(int i=1;i<len;i++){ //这步计算B[i]=A[0]*A[1]*...*A[i-1]；
            b[i] = b[i-1] * A[i-1];
        }
        int temp = 1; //用于指代A[i]
        for(int j = len-2;j>=0;j--){//这步计算B[i] *= A[i+1]*...*A[n-1]；
            temp *= A[j+1];
            b[j] *= temp;
        }
        return b;
    }
}