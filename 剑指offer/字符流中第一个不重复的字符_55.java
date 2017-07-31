/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
*/

public class Solution {
    int[] table = new int[256];
    StringBuilder s = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s.append(ch);
        table[ch] += 1;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	char[] c = s.toString().toCharArray();
        for(char ch : c){
            if(table[ch]==1)
                return ch;
        }
        return '#';
    }
}