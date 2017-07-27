/*
�����и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S���������ѭ������Kλ������������
���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
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