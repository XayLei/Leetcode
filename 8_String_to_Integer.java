public class Solution {
    public int myAtoi(String str) {
        //判断字符串是否为空
        if(str==null || str.length()==0) return 0;
        //去除字符串头尾的空格
        str = str.trim();
        //处理正负号
        boolean positive = true;
        int i =0;
        if(str.charAt(i)=='+'){
            i++;
        }else if(str.charAt(i)=='-'){
            positive = false;
            i++;
        }
        
        double tmp = 0;
        for(;i<str.length();i++){
            int digit = str.charAt(i) - '0';
            //判断字符是否为数字，如果不是，则直接跳出循环
            if(digit<0 || digit>9) break;
            
            if(positive){
                tmp = tmp*10 + digit;
                //判断数值是否超出int的范围，如果超出，直接返回int最大值128
                if(tmp>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }else{
                tmp = tmp*10 - digit;
                if(tmp<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        //强制类型转换
        int ret = (int)tmp;
        return ret;
    }
}
