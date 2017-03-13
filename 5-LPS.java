/*
使用Manacher算法求解：
  算法参考：
         https://segmentfault.com/a/1190000003914228
         http://www.cnblogs.com/grandyang/p/4475985.html
*/
public class Solution{
   public String longestPalindrome(String s){
      if(s.length() < 2) return s;
      
      //预处理字符串，避免奇偶问题
      String str = preProgress(s);
      
      //idx是当前能够向右延伸的最远的回文串中心点
      //max是当前最长回文串在总字符串中所能延伸到的最右端的位置
      //maxIdx是当前已知的最长回文串中心点
      //maxSpan是当前最长回文串的半径
      int idx =0, max=0;
      int maxIdx =0, maxSpan=0;
      int[] p = new int[str.length()];
      
      for(int i=1; i<str.length(); i++){
         //找出i相对于idx的对称点
         int symmetry = 2 * idx - 1;
         //如果当前已知延伸的最右端大于当前下标，我们可以用对称点的P值，否则记为1等待检查
         p[i] = max > i? Math.min(p[symmetry], max-i) : 1;
         //检查并更新当前下标为中心的回文串最远延伸的长度
         while((i+p[i])<str.length() && str.charAt(i+p[i]==str.charAt(i-p[i])){
            p[i]++;
         }
         // 检查并更新当前已知能够延伸最远的回文串信息
         if(i+p[i]>max){
            max = p[i] + i;
            idx = i;
          }
          // 检查并更新当前已知的最长回文串信息
          if(p[i]>maxSpan){
             maxSpan = p[i];
             maxIdx = i;
          }
       }
       return s.subString((maxIdx-maxSpan)/2, (maxIdx+maxSpan)/2-1);
   }
   
   private String preProgress(String s){
      StringBuilder sb = new StringBuilder();
      sb.append("$");
      for(int i = 0 ; i < s.length() ; i++ ){
         sb.append("#");
         sb.append(s.charAt(i));
      }
      sb.append("#");
      return sb.toString();
   }
}
