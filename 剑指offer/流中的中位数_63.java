import java.util.ArrayList;
import java.util.Collections;
public class Solution {
	ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
    	list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        int len = list.size();
        double result;
        int i;
        if(len%2==0){
            i = len/2;
            result = (double)(list.get(i)+list.get(i-1))/2;
        }else{
            i = len/2;
            result = (double)list.get(i);
        }
        return result;
    }


}