public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(pattern==null || str== null)
            return false;
        return matchCore(str,pattern,0,0);
    }
    
    public boolean matchCore(char[] str,char[] pattern, int i, int j){
        if(i==str.length && j==pattern.length) //��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
            return true;
		
        if(i != str.length && j==pattern.length) //pattern�ȵ�β��ƥ��ʧ��
            return false;
		
		//ģʽ��2����*�����ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ���粻ƥ�䣬ģʽ����2λ
        if(j + 1 < pattern.length && pattern[j+1] == '*'){
			//Խ����Ҫ�Ƚ��У�����ͻ��׳�Խ���쳣
            if((i != str.length && pattern[j]==str[i]) || (pattern[j]=='.' && i != str.length))
                return matchCore(str,pattern,i+1,j+2) || matchCore(str,pattern,i+1,j) || matchCore(str,pattern,i,j+2);
            else
                return matchCore(str,pattern,i,j+2);
        }
        
		 //ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
        if((i != str.length && str[i]==pattern[j]) || (pattern[j]=='.' && i != str.length))
            return matchCore(str,pattern,i+1,j+1);
        return false;
    }
}
