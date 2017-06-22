/*
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
*/

public class Solution {
    public int RectCover(int target) {
		int[] result = {0,1};
        if(target < 2){
            return result[target];
        }
        
        int fibNMinusOne = 1;
        int fibNMinusTwo = 1;  //这里的斐波那契数列为0,1,2,3,5.....
        int fibN = 0;
        for(int i=2;i<=target;++i){
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        
        return fibN;
    }
}