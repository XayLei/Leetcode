public class Solution {
    public int romanToInt(String s) {
    //如果没有边界判断，系统超时
    if(s==null || s.length()==0) return 0;
    Map<Character,Integer> m = new HashMap<>();
		m.put('M', 1000);
		m.put('D', 500);
		m.put('C', 100);
		m.put('L', 50);
		m.put('X', 10);
		m.put('V', 5);
		m.put('I', 1);
		
    int re = m.get(s.charAt(s.length()-1));
    for (int i = s.length()-2; i >= 0; i--) {
    if(m.get(s.charAt(i)) >= m.get(s.charAt(i+1)))
       re +=  m.get(s.charAt(i));
    else
	     re -=  m.get(s.charAt(i));			
    }
    return re;
    }
}
