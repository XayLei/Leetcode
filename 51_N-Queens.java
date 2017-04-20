public class Solution{
   public List<List<String>> solveNQueens(int n){
      //创建一个二维数组
      char[][] board = new char[n][n];
      List<List<String>> res = new ArrayList<>();
      
      //初始化二维数组
      for(int i =0; i<n; i++){
         for(int j =0; j<n; j++){
            board[i][j] = '.';
         }
      }
      
      dfs(board, 0, res);  //从第一列开始
      return res;
   }
   
   public void dfs(char[][] board, int col, List<List<String>> res){
      if(col == board[0].length){
          res.add(construct(board));
          return;
      }
      
      //遍历二维数组的每一行
      for(int i=0; i<board.length; i++){
          //先要判断在第i行第col列是否可以放置QUEEN
          if(vaildate(board, i, col)){
             board[i][col] = 'Q';   //判断可以在此位置放置QUEEN，则给此位置赋Q
             dfs(board, col+1, res);  //递归，在下一列的每一行寻找放置Q的最佳位置
             board[i][col] = '.';  //每次dfs后，将该位置复原，以便下一次继续遍历赋值
          }
      }
   }
   
   public boolean vaildate(char[][] board, int x, int y){
      //遍历访问前Y列的每一行的每一个元素
      for(int i=0; i<board.length; i++){
         for(int j=0; j<y; j++){   //这里直接就排除了两个Q在同一列的可能
            if(board[i][j]=='Q' && (x+y == i+j || x==i || x-i == y-j)){
               return false;
            }
         }
      }
      return true;
   }
   
   public List<String> construct(char[][] board){
      List<String> re = new ArrayList<>();
      for(int i =0; i<board.length; i++){
         String s = new String(board[i]);
         re.add(s);
      }
      return re;
   }
}
