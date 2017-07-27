import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array==null || array.length<2) return list;
        int n=array.length,i = 0,j = n-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
        		list.add(array[j]);
                break;
            }else if(array[i]+array[j]<sum){
                i++;
            }else{
                j--;
            }
        }
        return list;
    }
}