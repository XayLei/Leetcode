/*
现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
*/

import java.lang.StringBuilder;
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str=="" || str.length()==0) return "";
        if(n == 0) return str;
        if(n>=str.length()){
            n = n % str.length();
        }
        StringBuilder s = new StringBuilder();
        s.append(str.substring(n));
        s.append(str.substring(0,n));
        return s.toString();
    }
}