//这里的思想类似于DFS，遍历整个数组，先找到第一个匹配的字符，然后以这个字符为起点进行DFS递归匹配

public class Solution{
    public boolean exist(char[][] board, String word){
        if(board==null || board.length==0)
            return false;
        if(word.length() == 0)
            return true;
            
        for(int i =0; i < board.length; i++){
           for(int j=0; j < board[0].length; j++){
               if(board[i][j] == word.charAt(0)){
                   boolean r = find(board, i , j , word , 0);  //这里不能直接return，因为这只是其中的一种情况
                   if(r)  return true;
               }
           }
        }
        
        return false;
    }
    
    public boolean find(char[][] board, int i, int j, String word, int start){
        if(start == word.length())  return true;
        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j] != word.charAt(start))
           return false;
        
        //标记已经匹配过的字符
        board[i][j] = '#';
        //递归匹配当前字符在二维字符数组中的上下左右邻接字符
        boolean ret = find(board, i+1 , j , word , start+1) || find(board, i-1 , j , word , start+1)
                      || find(board, i , j+1 , word , start+1)  || find(board, i , j-1 , word , start+1);
        //将标记过的字符还原
        board[i][j] = word.charAt(start);
        return ret;
    }
}
