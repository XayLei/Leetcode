import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<Integer> re = new ArrayList<>();
       if(matrix==null || matrix.length<=0 || matrix[0].length<=0) return re;
       int rows = matrix.length, col = matrix[0].length;
       int start = 0; //表示圈数，也表示每一圈的起始坐标
       while(rows>start*2 && col>start*2){ //由外至内，按圈数遍历，最后一圈的起始坐标的2倍如果大于矩阵阶数，则停止
           help(matrix,rows,col,start,re);
           ++start;
       }
       return re;
    }
    public void help(int[][] matrix, int rows, int col, int start, ArrayList<Integer> re){
        int endx = col-1-start; //每一圈的列
        int endy = rows-1-start;//每一圈的行
        
		//从左到右
        for(int i = start; i <= endx; i++){
            re.add(matrix[start][i]);
        }
        //从右上到右下
        if(start<endy){
            for(int i = start + 1; i<=endy; i++){ //遍历时要排除第一个，因为在行遍历时已经访问过
                re.add(matrix[i][endx]);
            }
        }
        //从右下到左下，列数递减
        if(start<endx && start<endy){
            for(int i=endx-1; i>=start; i--){
                re.add(matrix[endy][i]);
            }
        }
        //从左下到左上，行数递减
        if(start<endx && start<endy-1){
            for(int i = endy-1;i>start; i--){
                re.add(matrix[i][start]);
            }
        }
    }
}