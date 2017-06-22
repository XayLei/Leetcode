/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
*/

public class Solution {
    boolean invalidInput = false;
    public double Power(double base, int exponent) {
        invalidInput = false;
        if(Solution.equal(base,0.0) && exponent<0){ //如果基数为0且指数为负数，则直接返回0，因为0的负次方错误。
            invalidInput = true;
            return 0.0;
        }
        
        int absExponent = exponent;  //考虑负次方的情况，所以提前对指数取绝对值
        if(exponent<0){ //取指数的绝对值
            absExponent = -exponent;
        }
        double result = Solution.pow(base,absExponent);
        
        if(exponent < 0) //如果指数为负，则还要取倒数
            result = 1.0 / result;
        
        return result;
    }
    
    public static double pow(double base,int exponent){
        if(exponent == 0) return 1;
        if(exponent == 1) return base;
        
        double result = 1.0;
        for(int i=1;i<=exponent;i++){  //判断指数是否是奇数
            result *= base;
        }
        return result;
    }
    
    public static boolean equal(double num1,double num2){
        if(num1-num2 > -0.0000001 && num1-num2<0.0000001){
            return true;
        }else{
            return false;
        }
    }
}