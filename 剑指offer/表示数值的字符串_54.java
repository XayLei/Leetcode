public class Solution{
	public boolean isNum(char[] str){
		String s = String.valueOf(str);
		return s.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");//'*'��λ��Σ���+��һ�λ��Σ���������λ�һ��
	}
}