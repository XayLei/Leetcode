/*
��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
*/
public class Solution {
    public String ReverseSentence(String str) {
        if (str.trim().equals(""))
			return str;
		String[] s = str.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = s.length - 1; i > 0; i--) {
			sb.append(s[i]);
			sb.append(" ");
		}
		sb.append(s[0]);
		return sb.toString();
    }
}