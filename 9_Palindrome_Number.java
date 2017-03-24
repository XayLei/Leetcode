public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        
        //确定X有几个零，即确定X是几位数
        int div=1;
        while(x/div >= 10){
            div = div * 10;
        }
        
        while(x!=0){
            //取最左边的数字
            int left = x/div;
            //取最右边的数字
            int right = x%10;
            //如果左右两边数字不相等，直接返回false，结束程序
            if(left != right) return false;
            
            //取余是去掉前面的最高位数字，除10是去掉最低为数字
            x=(x%div)/10;
            //更新div，因为上面已经拿掉了两位数字，所以相应的div也应该少两个零
            div = div/100;
        }
        
        return true;
    }
}
