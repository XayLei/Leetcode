public class Solution {
    public void nextPermutation(int[] nums) {
      if(nums.length<=1){
          return;
      }
      
      int i= nums.length-1;
      
      for(;i>=1;i--){
         
         if(nums[i]>nums[i-1]){ //6��3��4��9��8��7��1,�൱��Ϊ���ҵ�9������
             break;
         }
      }
      
      if(i!=0){  //����5,4,3,2,1���������
          swap(nums,i-1); //����4,9�ĺ�һ��Ԫ��
      }
      
      reverse(nums,i);    //��7֮���Ԫ��������
    }
    
    private void swap(int[] a,int i){  //��4֮����������У��Ӻ���ǰ�ҵ���һ������4��Ԫ�أ����н���
        for(int j = a.length-1;j>i;j--){
            if(a[j]>a[i]){ //��7��4����
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                break;
            }
        }
    }
    
    private void reverse(int[] a,int i){//��������������н�������
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