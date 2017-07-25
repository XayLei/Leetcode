import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        if(sum < 3) return al;
        int left = 1, right = 2, mid = (sum+1)/2;
        int curSum = left + right;
        
        while(left < mid){
            if(curSum == sum){
                help(al,left,right);
                curSum -= left;
                left++;
                right++;
                curSum += right;
            }else if(curSum < sum){
                right++;
                curSum += right;
            }else{
                curSum -= left;
                left++;
            }
        }
        return al;
    }
    
    public void help(ArrayList<ArrayList<Integer>> al, int left, int right){
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = left; i<=right; i++){
            a.add(i);
        }
        al.add(a);
    }
}