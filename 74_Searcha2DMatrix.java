public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        boolean found = false;
        int rows=matrix.length;
        int column = matrix[0].length-1;
        int row = 0;
		//从右至左，从上到下搜索矩阵
        while(row<rows && column>=0){
            if(matrix[row][column] == target){
                found = true;
                break;
            }else if(matrix[row][column] > target){
                column--;
            }else{
                row++;
            }
        }
        return found;
    }
}