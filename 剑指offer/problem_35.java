import java.util.HashMap;
//41ms
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length()==0) return -1;
        HashMap<Character,Integer> hash = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(hash.containsKey(str.charAt(i))){
                hash.put(str.charAt(i),2);
            }else{
                hash.put(str.charAt(i),1);
            }
        }
        int re = 0 ;
        for(int i=0; i<str.length();i++){
            if(hash.get(str.charAt(i))==1){
                re = i;
                break;
            }
        }
        return re;
    }
}
//25ms
public class Solution {
    public int FirstNotRepeatingChar(String str) {
		char[] c = str.toCharArray();
		int[] a = new int[(int)'z'+1];//�����Ǵ�0��ʼ�ģ���dΪСzʱ������Ϊ122��������ﲻ��1��������ֻ��121����������ʱ�ͻ��׳�Խ���쳣
		for (char d : c)
			a[(int) d]++;
		for (int i = 0; i < c.length; i++)
			if (a[(int) c[i]] == 1){
                return i;
            }
		return -1;
    }
}