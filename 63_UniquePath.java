public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	//取矩阵的列数
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;
	//遍历矩阵中的每一行
    for (int[] row : obstacleGrid) {
		//遍历每行中的每个元素
        for (int j = 0; j < width; j++) {
            if (row[j] == 1)
                dp[j] = 0;
            else if (j > 0)
                dp[j] += dp[j - 1];
        }
    }
    return dp[width - 1];
}