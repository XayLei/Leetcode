/*
  题意理解：
     题意是n=1时输出字符串1；
          n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11；
          n=3时，由于上次字符是11，有2个1，所以输出21；
          n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211。
          依次类推，写个countAndSay(n)函数返回字符串。
*/

public class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        
        String str = countAndSay(n-1) + "*";  //后面的星号是为了方便遍历
        char[] c = str.toCharArray();
        int count = 1;
        StringBuilder s = new StringBuilder();
        for(int i=0; i<c.length-1; i++){
            if(c[i] == c[i+1]){
                count++;
            }else{
                s.append(count);
                s.append(c[i]);
                count=1;
            }
        }
        
        return s.toString();
    }
}
