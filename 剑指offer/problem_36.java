public class Solution {
    public int InversePairs(int [] array) {
        if(array==null || array.length==0) return 0;
        int[] help = new int[array.length];
        for(int i=0;i<array.length;i++)
            help[i] = array[i];
        int count = inverse(array,help,0,array.length-1);
        return count%1000000007;
    }
    public int inverse(int[] array, int[] help, int left, int right){
        if(left==right) return 0;
        int mid = (right+left)>>1;
        int countL = inverse(array,help,left,mid);
        int countR = inverse(array,help,mid+1,right);
        int count=0,index=right;
        int j=right,i=mid;
        while(i>=left && j>mid){
            if(array[i]>array[j]){
                count += j-mid;
                help[index--] = array[i--];
            }else{
                help[index--] = array[j--];
            }
        }
        while(i>=left)
            help[index--] = array[i--];
        while(j>mid)
            help[index--] = array[j--];
        for(int k =0; k<=right; k++)
            array[k] = help[k];
        return (countL+countR+count);
    }
}