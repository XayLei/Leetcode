import java.util.Arrays;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int re = 0;
        if(array!=null || array.length==0){
            int mid = array.length/2,count = 0;
            for(int i=0;i<array.length;i++){
                if(array[i]==array[mid]){
                    count++;
                }
                if(count>mid){
                    re = array[mid];
                    break;
                }
            }
        }
        return re;
    }
}