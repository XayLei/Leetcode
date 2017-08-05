public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        int[] flag = new int[matrix.length];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){ //这两个for循环是为了表示从矩阵中的任一位置开始
                if(help(matrix,rows,cols,i,j,str,0,flag))
                    return true;
            }
        }
        return false;
    }
    
	//k代表的是目标字符串中的索引
    public boolean help(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag){
        int index = i*cols+j; //矩阵中的当前位置
        if(i<0 || i>=rows || j<0 || j>=cols || matrix[index] != str[k] || flag[index]==1)//flag[index]==1表示路径中出现重复矩阵元素
            return false;
        if(k==str.length-1) //已经到目标字符串的最后一个位置
            return true;
        flag[index]=1;//设置已遍历标记
		//当前位置的上下左右位置的递归比较
        if(help(matrix,rows,cols,i-1,j,str,k+1,flag) || help(matrix,rows,cols,i+1,j,str,k+1,flag)
          		|| help(matrix,rows,cols,i,j-1,str,k+1,flag) || help(matrix,rows,cols,i,j+1,str,k+1,flag))
            return true;
        flag[index]=0;//恢复默认
        return false;
    }
}