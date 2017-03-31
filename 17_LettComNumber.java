public class Solution {
    ArrayList<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
		if (digits == null || digits.equals(""))
			System.out.println(result);

		String[] table = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		StringBuilder tmp = new StringBuilder();

		// 深度优先搜索DFS
		helper(table, digits, tmp, 0);
		
		return result;
    }
    
    	private void helper(String[] table, String digit, StringBuilder tmp, int index) {
		//判断结果字符串的长度与数字字符串长度是否相同，如果相同，就说明找到了其中的一种结果
		if (index == digit.length()) {
			//找到一种结果，加入列表
			if (tmp.length() != 0)
				result.add(tmp.toString());
		} else {
			//找出当前数字对应的的字母字符串
			String candiates = table[digit.charAt(index) - '0'];
			//遍历字母字符串中的每一个字母
			for(int i =0; i<candiates.length();i++){
				tmp.append(candiates.charAt(i));
				helper(table,digit,tmp,index+1);
				tmp.deleteCharAt(tmp.length()-1);
			}
		}
	}
}
