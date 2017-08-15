public class Solution {
    public int[] twoSum(int[] num, int tar) {
        int start = 0, end = num.length-1;
        while(num[start]+num[end] != tar){
            if(num[start]+num[end]>tar){
                end--;
            }else{
                start++;
            }
        }
        return new int[]{start+1,end+1};
    }
}_