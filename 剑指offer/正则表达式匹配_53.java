public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(pattern==null || str== null)
            return false;
        return matchCore(str,pattern,0,0);
    }
    
    public boolean matchCore(char[] str,char[] pattern, int i, int j){
        if(i==str.length && j==pattern.length) //有效性检验：str到尾，pattern到尾，匹配成功
            return true;
		
        if(i != str.length && j==pattern.length) //pattern先到尾，匹配失败
            return false;
		
		//模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if(j + 1 < pattern.length && pattern[j+1] == '*'){
			//越界检查要先进行，否则就会抛出越界异常
            if((i != str.length && pattern[j]==str[i]) || (pattern[j]=='.' && i != str.length))
                return matchCore(str,pattern,i+1,j+2) || matchCore(str,pattern,i+1,j) || matchCore(str,pattern,i,j+2);
            else
                return matchCore(str,pattern,i,j+2);
        }
        
		 //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if((i != str.length && str[i]==pattern[j]) || (pattern[j]=='.' && i != str.length))
            return matchCore(str,pattern,i+1,j+1);
        return false;
    }
}
