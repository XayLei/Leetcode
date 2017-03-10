public class Solution{
   public int lengthOfLongestSubstring(String s){
       //定义一个数组，数组长度为ASCALL扩展码的容量，即定义一个字母数组
       int[] map = new int[256];
       
       int i = 0;
       int j = 0;
       int ans = 0; //最长子字符串的长度
       for( i = 0; i < s.length(); i++){
          while(j < s.length() && map[s.charAt(j)] == 0){
             map[s.charAt(j)] = 1;
             ans = Math.max(ans , j-i+1);
             j++;
          }
          map[s.charAt(i)] = 0;
       }
       return ans;
   }
/*
   //还有一种使用HashMap的方法，并使用两个指针i和j
   //用一个hash table保存每个字符上一次出现过的位置。
   //从前往后扫描，假如发现字符上次出现过，
   //就把当前子串的起始位置start移动到上次出现过的位置之后——这是为了保证从start到i的当前子串中没有任何重复字符。
   //同时，由于start移动，当前子串的内容改变，start移动过程中经历的字符都要剔除
   public int lengthOfSubstring(String s){
      if(s.length()==0) return 0;
      
      HashMap<Character,Integer> map = new HashMap<>();
      int max = 0;
      for(int i=0, j=0; i<s.length(); ++i){
         if(map.containsKey(s.charAt(i))){
            j = Math.max(j,map.get(s.charAt(i))+1);
         }
         map.put(s.charAt(i), i);
         max = Math.max(max,i-j+1);
      }
      return max;
   }
*/
}
