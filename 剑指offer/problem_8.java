/*
��һ�ֽⷨ��ֱ�ӱ�����⣬����ʱ�䣺 356 ms ռ���ڴ棺27128K
*/
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        for(int i =0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return 0;
    }
}

/*
�ڶ��ֽⷨ��ʹ�ö��ֲ��ң� ����ʱ�䣺 418 ms ռ���ڴ棺27344K
*/
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        int p1=0,p2=array.length-1;  //������������ָ��
        int minIndex = 0;
        while(p1<=p2){
            if(p2-p1==1){
                minIndex = p2;
                break;
            }
             
            int mid = (p2+p1)/2;
            if(array[mid]>=array[p1]){
                p1 = mid;
            }else if(array[mid]<=array[p2]){
                p2 = mid;
            }
        }
        return array[minIndex];
    }
}

/*
�����ֽⷨ������ʱ�䣺 530 ms ռ���ڴ棺27592K
*/
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        int p1=0,p2=array.length-1;
        int minIndex = 0;
        while(p1<=p2){
            if(p2-p1==1){
                minIndex = p2;
                break;
            }
             
            int mid = (p2+p1)/2;
            if(array[mid]==array[p1] && array[mid]==array[p2]) //������ָ�봦��ֵ�����ʱ��ʹ��˳���������
                return inOrderSearch(array,p1,p2);
             
            if(array[mid] >= array[p1]){
                p1 = mid;
            }else if(array[mid] <= array[p2]){
                p2 = mid;
            }
        }
        return array[minIndex];
    }
     
    private int inOrderSearch(int[] array,int p1,int p2){
        int result  = array[p1];
        for(int i = p1+1;i<=p2;i++){
            if(result>array[i])
                result = array[i];
        }
        return result;
    }
}