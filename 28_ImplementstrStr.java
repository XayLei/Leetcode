/*
�жϵڶ����ַ����Ƿ�Ϊ��һ���ַ������Ӵ�
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
		//ע�������ѭ���ж�������һ��Ҫ��С�ڵ��ڣ����û�е��ڣ������ж�������������ͬʱ�����
        for(int i=0; i<=diff; i++){
            if(haystack.substring(i,i+n2).equals(needle))
               return i;
        }
        return -1;
	}
}