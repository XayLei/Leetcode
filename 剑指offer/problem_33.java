import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
		if(numbers==null || numbers.length==0) return "";
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : numbers){
            list.add(i);
        }
        Collections.sort(list,new Comparator<Integer>(){
        		public int compare(Integer str1,Integer str2){
                	String s1 = str1 + "" + str2;
                	String s2 = str2 + "" + str1;
                	return s1.compareTo(s2);
            	}
            });
        StringBuilder s = new StringBuilder();
        for(Integer i : list){
            s.append(i);
        }
        return s.toString();
    }
}