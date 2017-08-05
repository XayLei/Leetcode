public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] flag = new int[rows][cols];
        return help(0,0,rows,cols,flag,threshold);
    }
    
    public int help(int i, int j, int rows, int cols,int[][] flag, int threshold){
        if(i<0 || i>=rows || j<0 || j>=cols || num(i)+num(j)>threshold || flag[i][j]==1)
            return 0;
        flag[i][j] = 1;
        return help(i-1,j,rows,cols,flag,threshold)+help(i+1,j,rows,cols,flag,threshold)
            +help(i,j-1,rows,cols,flag,threshold)+help(i,j+1,rows,cols,flag,threshold)+1;
    }
    
    public int num(int k){
        int sum=0;
        while(k>0){
            sum += k%10;
            k = k/10;
        }
        return sum;
    }
}