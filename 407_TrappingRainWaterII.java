public class Solution {

    public class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return 0;

		//PriorityQueue的底层实现是一个小顶堆，每次poll出的cell都是height最小的
        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){ //插入每个cell时，按height进行排序
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];

        //将位于四条边上的所有cell放入容器，并把visited的相对应位置设为TRUE
        for (int i = 0; i < m; i++) {  //左边（0）和右边（n-1）的每一行
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
        }

        for (int i = 0; i < n; i++) { //上边（0）和下边（m-1）的每一列
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heights[0][i]));
            queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
        }

        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
       // add all its neighbors to the queue.
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //分别表示当前cell的左邻接，右邻接，上邻接和下邻接
        int res = 0;  //返回值
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {  //遍历当前cell的左右上下cell
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
				//这个条件语句保证了只会判断围墙内的cell（将上下左右看做围墙，只判断围墙内的cell）
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) { //当邻接cell在矩阵内，并且没有被访问过时
                    visited[row][col] = true;  // 将此邻接cell设为访问过
                    res += Math.max(0, cell.height - heights[row][col]);  //更新res值，当 当前cell的如果高于邻接cell 时
					//将此邻接位置的坐标作为新cell的坐标，高度取当前cell与邻接cell的最大值
                    queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
                }
            }
        }
        
        return res;
    }
}