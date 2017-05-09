/*
判断第二个字符串是否为第一个字符串的子串
*/

public class Solution{
	public int strStr(String hayStack, String needle){
		int n1 = haystack.length();
        int n2 = needle.length();
        if(n2>n1){
            return -1;
        }else if(n2==0){
            return 0;
        }
        
        int diff = n1-n2;
		//注意这里的循环判断条件，一定要是小于等于，如果没有等于，则在判断两个串长度相同时会出错
        for(int i=0; i<=diff; i++){
            if(haystack.substring(i,i+n2).equals(needle))
               return i;
        }
        return -1;
	}
}