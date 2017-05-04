/*
  题意：
      整型数组digits代表一个整数，例如98，即digits[0]=9,digits[1]=8
	  题目要求是对这个整数加1后，返回一个新的整型数组
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
		//遍历整数的每一位，从个位开始
        for(int i=n-1; i>=0; i--){
			//如果第I位小于9，则直接对这位加1，返回digits即可
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            
			//如果第i位等于9，则加1后，I位变0，并对下一位加1（即向高位进1）
            digits[i] = 0;
        }
        
		//当给定的整数是0时，则新创建一个数组，并将数组第一位设为1；
        int[] newNum = new int[n+1];
        newNum[0] = 1;
        return newNum;
    }
}