public class Solution{
   //还有一种使用HashMap的方法，并使用两个指针向前移动....
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
}
