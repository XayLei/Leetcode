public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>(); //用唯一的字符串做键，用链表做值
        for(String s : strs){
            char[] ca = s.toCharArray(); //先转换为字符数组，然后排序，最后再转回字符串，就变为了可以做键的字符串
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr)) map.put(keyStr,new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        
        return new ArrayList<List<String>>(map.values()); //直接利用构造方法创建返回值
    }
}