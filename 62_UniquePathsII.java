//动态规划问题，计算从矩阵左上角到右下角一共有多少条不同的路径

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] diagram = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
				//将矩阵的第一行和第一列初始化为1
                if(i==0 || j==0){
                    diagram[i][j] = 1;
                }else{
                    diagram[i][j] = diagram[i-1][j] + diagram[i][j-1];
                }
            }
        }
        
		//返回矩阵右下角的值
        return diagram[m-1][n-1];
    }
}