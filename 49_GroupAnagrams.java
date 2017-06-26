public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>(); //��Ψһ���ַ�����������������ֵ
        for(String s : strs){
            char[] ca = s.toCharArray(); //��ת��Ϊ�ַ����飬Ȼ�����������ת���ַ������ͱ�Ϊ�˿����������ַ���
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr)) map.put(keyStr,new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        
        return new ArrayList<List<String>>(map.values()); //ֱ�����ù��췽����������ֵ
    }
}