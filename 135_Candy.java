/*
：这道题自己由简单越想越复杂。首先，我们把所有的case分开看。如果把rating画成图，那么只有两种case: 
1. 递增：num[i] = num[i-1]+1; 
2. 递减：num[i] = num[i+1] +1;

会不会引用一个未定义的值？不会，因为我们可以对所有num先初始化为1。 
既然有了这种规律，我们就可以来两次遍历： 
从左到右：这样将把所有递增的点确定值。 
从右到左：所有递减的点确定了值。 
转折点呢？取二者的最大值。
*/

public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
        
        int n = ratings.length;
        int[] re = new int[n];
        re[0] = 1;
        for(int i = 1; i<n; i++){
            re[i] = 1;
            if(ratings[i] > ratings[i-1]){
                re[i] = re[i-1] + 1;
            }
        }
        
        for(int j = n-2; j>=0; j--){
            if(ratings[j] > ratings[j+1]){
                re[j] = Math.max(re[j], re[j+1]+1);
            }
        }
        
        int count = 0;
        for(int m=0;m<n;m++){
            count += re[m];
        }
        
        return count;
    }
}