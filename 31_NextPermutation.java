public class Solution {
    public void nextPermutation(int[] nums) {
      if(nums.length<=1){
          return;
      }
      
      int i= nums.length-1;
      
      for(;i>=1;i--){
         
         if(nums[i]>nums[i-1]){ //6，3，4，9，8，7，1,相当于为了找到9的索引
             break;
         }
      }
      
      if(i!=0){  //不是5,4,3,2,1这种情况下
          swap(nums,i-1); //交换4,9的后一个元素
      }
      
      reverse(nums,i);    //将7之后的元素重排序
    }
    
    private void swap(int[] a,int i){  //在4之后的子序列中，从后向前找到第一个大于4的元素，进行交换
        for(int j = a.length-1;j>i;j--){
            if(a[j]>a[i]){ //将7与4交换
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                break;
            }
        }
    }
    
    private void reverse(int[] a,int i){//将交换后的子序列进行排序
        int first = i;
        int last = a.length-1;
        while(first<last){
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }
    
}