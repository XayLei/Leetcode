public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
		    if(strs.length<2) return strs[0];
		
        //公共前缀的最大长度是strs中长度最小的字符串的长度		
        int minLen = strs[0].length();
		    for (int i = 1; i < strs.length; i++) {
			      minLen = Math.min(minLen, strs[i].length());
		    }
        
        //第一次for循环遍历每个字符串中的前minlen个字符		
        for(int i=0;i<minLen;i++){
        //遍历数组中的每一个字符串			
        for(int j=0;j<strs.length-1;j++){
				         String s1 = strs[j];
				         String s2 = strs[j+1];
                 //如果出现字符不匹配的情况，立即终止遍历，返回前缀				
                 if(s1.charAt(i)!=s2.charAt(i))
					            return s1.substring(0, i);
			      }
		    }
		    return strs[0].substring(0, minLen);
    }
}
