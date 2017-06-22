/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
*/

public class Solution {
    public int NumberOf1(int n) {
		String re = Integer.toBinaryString(n);
        int count=0;
        for(int i=0;i<re.length();i++){
            if(re.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}

public class Solution {
    public int NumberOf1(int n) {
		int count = 0;
        while(n != 0){
            ++ count;
    //把一个整数减去1，再和原整数做与运算，会把该整数的最右边的1变成0，一个整数的二进制表示有多少个1，就可以进行多少次这样的操作
        n = (n-1) & n ;
		}
        
        return count;
    }
}