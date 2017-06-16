public class Solution {
    public boolean Find(int target, int [][] array) {
        int rows = array.length,columns=array[0].length;
        if(array!=null && rows>0 && columns>0){
            int row = 0;//�в�ѯ��ʼλ���ǵ�һ�У�����0��
            int col = columns-1; //�в�ѯ��ʼλ��Ϊ���һ��
            while(row<rows && col >=0){
                if(array[row][col] > target){ //��ÿ�е���Сֵ��С����ѯǰһ��
                    --col;
                }else if(array[row][col] < target){ //��ÿ�е����ֵ���󣬲�ѯ��һ��
                    ++row;
                }else if(array[row][col]==target){  //�ҵ�Ŀ����������true
                    return true;
                }
            }
        }
        return false;
    }
}