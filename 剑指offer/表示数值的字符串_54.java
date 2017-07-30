public class Solution{
	public boolean isNum(char[] str){
		String s = String.valueOf(str);
		return s.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");//'*'零次或多次，‘+’一次或多次，‘？’零次或一次
	}
}