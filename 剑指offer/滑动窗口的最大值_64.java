import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(num.length==0 || size==0)
            return list;
        int i=0,j=size-1;
        while(j<num.length){
            list.add(findMax(num,i,j));
            i++;
            j++;
        }
        return list;
    }
    
    public int findMax(int[] num, int i, int j){
        int max = num[i];
        for(int k=i+1;k<=j;k++){
            max = Math.max(max,num[k]);
        }
        return max;
    }
}