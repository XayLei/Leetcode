/*
��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ��
��һ��ֻ����һ�ε��ַ���"g"�����Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
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