public class Solution {
    public boolean Find(int target, int [][] array) {
        int rows = array.length,columns=array[0].length;
        if(array!=null && rows>0 && columns>0){
            int row = 0;//行查询起始位置是第一行，即第0行
            int col = columns-1; //列查询起始位置为最后一列
            while(row<rows && col >=0){
                if(array[row][col] > target){ //比每列的最小值还小，查询前一列
                    --col;
                }else if(array[row][col] < target){ //比每行的最大值还大，查询下一行
                    ++row;
                }else if(array[row][col]==target){  //找到目标数，返回true
                    return true;
                }
            }
        }
        return false;
    }
}