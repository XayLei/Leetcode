public class Solution{
	public int lengthOfLastWord(String s){
		//����һ���ַ��������һ�����ʵĳ��ȣ�String.lastIndexOf()�������һ���ո񴦵�����
		return s.trim().length()-s.trim().lastIndexOf(' ')-1;
	}
}