//Ѱ��һ��������һ�����������г����˶��ٴΣ�
//����һ���㷨��ͨ���������ֲ����ҵ�Ŀ�����ֵ�һ�κ����һ�γ��ֵ�������������
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length==0) return 0;
        int index = find(array,k,0,array.length-1);
        int count=1,i=index-1,j=index+1;
        if(index == -1) return 0;
        else{
            while(i>=0 && array[i]==array[index]){
            	count++;
            	i--;
        	}
        	while(j<array.length && array[j]==array[index]){
            	count++;
            	j++;
        	}
        }
        return count;
    }
    
    public int find(int[] array, int k,int left, int right){
        if(left>right) return -1;
        int mid = (right+left)/2;
        int index = -1;
        if(array[mid]==k) index = mid;
        if(array[mid]>k) index = find(array,k,left,mid-1);
        if(array[mid]<k) index = find(array,k,mid+1,right);
        return index;
    }
}