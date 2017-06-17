/*
整体思路：考虑负数，大数，算法的复杂度，空间的浪费

斐波那契数列:0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233……

如果用递归的话，就是f(n)=f(n-1)+f(n-2),但可能造成栈溢出。
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